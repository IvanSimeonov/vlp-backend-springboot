package bg.tusofia.vlp.assignment.service;

import bg.tusofia.vlp.assignment.domain.SubmissionStatus;
import bg.tusofia.vlp.assignment.dto.AssignmentSolutionCreateDto;
import bg.tusofia.vlp.assignment.dto.AssignmentSolutionDto;
import bg.tusofia.vlp.assignment.mapper.AssignmentSolutionMapper;
import bg.tusofia.vlp.assignment.repository.AssignmentSolutionRepository;
import bg.tusofia.vlp.exception.AssignmentSolutionNotFoundException;
import bg.tusofia.vlp.exception.FileStorageException;
import bg.tusofia.vlp.exception.LectureNotFoundException;
import bg.tusofia.vlp.exception.UserNotFoundException;
import bg.tusofia.vlp.lecture.repository.LectureRepository;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.List;

/**
 * Class: AssignmentSolutionServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@Transactional
@RequiredArgsConstructor
public class AssignmentSolutionServiceImpl implements AssignmentSolutionService {
    private final AssignmentSolutionRepository assignmentSolutionRepository;
    private final AssignmentSolutionMapper assignmentSolutionMapper;
    private final LectureRepository lectureRepository;
    private final UserRepository userRepository;

    @Value("${user.course.lecture.assignment.upload-dir}")
    private String uploadDir;

    @Override
    public List<AssignmentSolutionDto> getAllSolutionsByCourseId(Long courseId) {
        return assignmentSolutionRepository
                .findAllByLecture_Course_Id(courseId)
                .stream()
                .map(assignmentSolutionMapper::assignmentSolutionToAssignmentSolutionDto)
                .toList();
    }

    @Override
    public AssignmentSolutionDto getSolutionByLectureAndUser(Long lectureId, Long userId) {
        return assignmentSolutionRepository
                .findByLecture_IdAndStudent_Id(lectureId, userId)
                .map(assignmentSolutionMapper::assignmentSolutionToAssignmentSolutionDto)
                .orElse(null);
    }

    @Override
    public List<AssignmentSolutionDto> getAllSolutionsByCourseAndUser(Long courseId, Long userId) {
        return assignmentSolutionRepository
                .findAllByLecture_Course_IdAndStudent_Id(courseId, userId)
                .stream()
                .map(assignmentSolutionMapper::assignmentSolutionToAssignmentSolutionDto)
                .toList();
    }

    @Override
    public Resource getAssignmentSolutionFile(Long assignmentSolutionId) {
        var assignmentSolution = assignmentSolutionRepository
                .findById(assignmentSolutionId)
                .orElseThrow(() -> new AssignmentSolutionNotFoundException(assignmentSolutionId));
        Path filePath = Paths.get(assignmentSolution.getSubmissionFilePath());
        if (!Files.exists(filePath)) {
            throw new FileStorageException("Assignment solution file was not found on the server");
        }
        try {
            return new UrlResource(filePath.toUri());
        } catch (MalformedURLException e) {
            throw new FileStorageException("Error loading the file", e);
        }
    }

    @Override
    public AssignmentSolutionDto uploadAssignmentSolution(AssignmentSolutionCreateDto assignmentSolutionCreateDto) {
        var userId = getCurrentAuthenticatedUser().getId();
        var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        var lecture = lectureRepository
                .findLectureById(assignmentSolutionCreateDto.lectureId())
                .orElseThrow(
                        () -> new LectureNotFoundException(assignmentSolutionCreateDto.lectureId())
                );
        var filePath = saveAssignmentFile(assignmentSolutionCreateDto.file());

        var assignmentSolution = assignmentSolutionMapper.assignmentSolutionCreateDtoToAssignmentSolution(assignmentSolutionCreateDto);
        assignmentSolution.setSubmissionStatus(SubmissionStatus.SUBMITTED);
        assignmentSolution.setSubmissionFilePath(filePath);

        lecture.addAssignmentSolution(assignmentSolution);
        user.addAssignmentSolution(assignmentSolution);
        var savedSolution = assignmentSolutionRepository.save(assignmentSolution);
        return this.assignmentSolutionMapper.assignmentSolutionToAssignmentSolutionDto(savedSolution);
    }

    @Override
    public void deleteAssignmentSolution(Long assignmentSolutionId) {
        var user = getCurrentAuthenticatedUser();

        var assignmentSolution = assignmentSolutionRepository
                .findById(assignmentSolutionId)
                .orElseThrow(() -> new AssignmentSolutionNotFoundException(assignmentSolutionId));
        var lecture = assignmentSolution.getLecture();

        lecture.removeAssignmentSolution(assignmentSolution);
        user.removeAssignmentSolution(assignmentSolution);

        assignmentSolutionRepository.delete(assignmentSolution);
        try {
            Files.deleteIfExists(Path.of(assignmentSolution.getSubmissionFilePath()));
        } catch (IOException e) {
            throw new FileStorageException("Failed to remove the file: " + assignmentSolution.getSubmissionFilePath(), e);
        }
    }

    @Override
    public void gradeAssignmentSolution(Long assignmentSolutionId, Integer grade) {
        var assignmentSolution = assignmentSolutionRepository.findById(assignmentSolutionId)
                .orElseThrow(() -> new AssignmentSolutionNotFoundException(assignmentSolutionId));
        assignmentSolution.setGrade(grade);
        assignmentSolution.setSubmissionStatus(SubmissionStatus.GRADED);
        assignmentSolutionRepository.save(assignmentSolution);
    }

    private String saveAssignmentFile(MultipartFile file) {
        var userId = getCurrentAuthenticatedUser().getId();
        var filePath = constructFilePath(userId, file.getOriginalFilename());
        try {
            Files.deleteIfExists(filePath);
            Files.copy(file.getInputStream(), filePath);
            return filePath.toString();
        } catch (IOException e) {
            throw new FileStorageException("Failed to save file");
        }
    }

    private Path constructFilePath(Long userId, String originalFilename) {
        var userDir = Paths.get(uploadDir, String.valueOf(userId));
        try {
            Files.createDirectories(userDir);
        } catch (IOException e) {
            throw new FileStorageException("Failed to create user directory");
        }
        var fileName = MessageFormat.format("assignment_user_{0}_{1}", userId, originalFilename);
        return userDir.resolve(fileName);
    }

    private User getCurrentAuthenticatedUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return (User) authentication.getPrincipal();
        }
        throw new IllegalArgumentException("Unauthorized access: No valid user context found");
    }
}
