package bg.tusofia.vlp.course.service;

import bg.tusofia.vlp.common.domain.UserCompletedCourse;
import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.domain.Status;
import bg.tusofia.vlp.course.dto.*;
import bg.tusofia.vlp.course.mapper.CourseMapper;
import bg.tusofia.vlp.course.repository.CourseRepository;
import bg.tusofia.vlp.course.repository.CourseSpecification;
import bg.tusofia.vlp.courserating.domain.CourseRating;
import bg.tusofia.vlp.courserating.dto.CourseRatingDto;
import bg.tusofia.vlp.courserating.mapper.CourseRatingMapper;
import bg.tusofia.vlp.courserating.repository.CourseRatingRepository;
import bg.tusofia.vlp.exception.*;
import bg.tusofia.vlp.topic.repository.TopicRepository;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.MessageFormat;
import java.util.List;

/**
 * Class: CourseServiceImpl
 * <p>
 * An implementation of the {@link CourseService} interface for managing courses.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseRatingRepository courseRatingRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final CourseMapper courseMapper;
    private final CourseRatingMapper courseRatingMapper;

    @Value("${user.course.image.upload-dir}")
    private String uploadDir;

    @Override
    public Long createCourse(CourseCreateDto courseCreateDto) {
        Course course = this.courseMapper.courseCreateDtoToCourse(courseCreateDto);
        User author = userRepository.findById(courseCreateDto.authorId())
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + courseCreateDto.authorId()));
        course.setAuthor(author);
        course.setStatus(Status.DRAFT);
        return courseRepository.save(course).getId();
    }

    @Override
    public CourseOverviewDto getCourseOverviewById(Long courseId) {
        var course = this.courseRepository.findCourseOverviewById(courseId);
        return this.courseMapper.courseOverviewToCourseOverviewDto(course);
    }

    @Override
    public Page<CourseManagementDto> getCourses(CourseSearchCriteriaDto criteria, PageRequest pageRequest) {
        var courses = courseRepository.findAll(CourseSpecification.getCoursesByCriteria(criteria), pageRequest);
        return courses.map(courseMapper::courseToCourseManagementDto);
    }

    @Override
    public Page<CourseOverviewDto> getPagedCourseOverviews(CourseSearchCriteriaDto criteria, PageRequest pageRequest) {
        var courses = courseRepository.findAll(CourseSpecification.getCoursesByCriteria(criteria), pageRequest);
        return courses.map(courseMapper::courseToCourseOverviewDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CourseAnalyticsDto> getCourseAnalytics() {
        return courseRepository.findCourseAnalytics();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CourseOverviewDto> getTopCoursesByStudentCount() {
        var courses = courseRepository.findTop10CoursesByStudentCount();
        return courses.stream().map(courseMapper::courseOverviewToCourseOverviewDto).toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void uploadCourseImage(long courseId, MultipartFile image){
        var course = courseRepository.findCourseById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        var imagePath = saveFile(image, courseId);
        course.setImagePath(imagePath);
        courseRepository.save(course);
    }

    @Override
    public void updateCourseById(Long courseId, CourseUpdateDto courseUpdateDto) {
        var course = this.courseRepository.findCourseById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        course.setTitle(courseUpdateDto.title());
        course.setFullDescription(courseUpdateDto.fullDescription());
        course.setDifficultyLevel(courseUpdateDto.difficultyLevel());
        course.setTopic(topicRepository.getReferenceById(courseUpdateDto.topicId()));
        courseRepository.save(course);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<CourseOverviewDto> getUserCreatedCourses(CourseSearchCriteriaDto searchCriteria, PageRequest pageRequest) {
        var user = getCurrentAuthenticatedUser();
        Specification<Course> specification = CourseSpecification.getCoursesByCriteria(searchCriteria)
                .and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("author"), user));
        Page<Course> enrolledCourses = courseRepository.findAll(specification, pageRequest);
        return enrolledCourses.map(courseMapper::courseToCourseOverviewDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<CourseOverviewDto> getUserEnrolledCourses(CourseSearchCriteriaDto searchCriteria, PageRequest pageRequest) {
        var user = getCurrentAuthenticatedUser();
        Specification<Course> specification = CourseSpecification.getCoursesByCriteria(searchCriteria)
                .and((root, criteriaQuery, criteriaBuilder) ->
                        criteriaBuilder.isMember(user, root.get("enrolledUsers"))
                );
        Page<Course> enrolledCourses = courseRepository.findAll(specification, pageRequest);
        return enrolledCourses.map(courseMapper::courseToCourseOverviewDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<CourseOverviewDto> getUserCompletedCourses(CourseSearchCriteriaDto searchCriteria, PageRequest pageRequest) {
        var user = getCurrentAuthenticatedUser();

        Specification<Course> specification = (root, criteriaQuery, criteriaBuilder) -> {
            Subquery<Long> subquery = criteriaQuery.subquery(Long.class);
            Root<Course> subRoot = subquery.from(Course.class);

            Join<Course, UserCompletedCourse> completedUsersJoin = subRoot.join("completedUsers");
            subquery.select(subRoot.get("id"))
                    .where(
                            criteriaBuilder.equal(subRoot.get("id"), root.get("id")),
                            criteriaBuilder.equal(completedUsersJoin.get("user"), user)
                    );

            Specification<Course> baseCriteria = CourseSpecification.getCoursesByCriteria(searchCriteria);
            Predicate basePredicate = baseCriteria.toPredicate(root, criteriaQuery, criteriaBuilder);
            return criteriaBuilder.and(basePredicate, criteriaBuilder.exists(subquery));
        };
        Page<Course> completedCourses = courseRepository.findAll(specification, pageRequest);
        return completedCourses.map(courseMapper::courseToCourseOverviewDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public CourseRatingDto rateCourse(Long courseId, CourseRatingDto courseRatingDto) {
        var course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        var user = userRepository.findById(courseRatingDto.userId()).orElseThrow(() -> new UserNotFoundException(courseRatingDto.userId()));
        var hasCompletedCourse = user.getCompletedCourses().stream().anyMatch(c -> c.getCourse().getId().equals(courseId));
        if (!hasCompletedCourse) {
            throw new CourseNotCompletedException(courseId);
        }
        if (courseRatingRepository.existsByCourseAndUser(course, user)) {
            throw new CourseAlreadyRatedException(courseId);
        }
        CourseRating courseRating = courseRatingMapper.courseRatingDtoToCourseRating(courseRatingDto);
        return courseRatingMapper.courseRatingToCourseRatingDto(courseRatingRepository.save(courseRating));
    }

    @Override
    public void updateCourseStatus(Long courseId, CourseStatusUpdateDto courseStatusUpdateDto) {
        var course = courseRepository.findCourseById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(courseId));
        var status = courseStatusUpdateDto.status();
        if (status.equals(Status.PUBLISHED) && (course.getLectures().isEmpty() || course.getLectures().size() < 3)) {
            throw new IllegalStateException("Cannot publish a course without the required amount of lectures.");
        }
        course.setStatus(status);
        courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long courseId) {
        var course = courseRepository.getReferenceById(courseId);
        if (!course.getEnrolledUsers().isEmpty() || !course.getCompletedUsers().isEmpty()) {
            throw new CannotDeleteCourseException(courseId);
        }
        courseRepository.deleteById(courseId);
    }

    @Override
    public void enrollUserToCourse(Long courseId) {
        var course = courseRepository.findCourseById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        var auth = getCurrentAuthenticatedUser();
        var user = userRepository.findById(auth.getId()).orElseThrow(() -> new UserNotFoundException(auth.getId()));

        if (user.getId().equals(course.getAuthor().getId())) {
            throw new IllegalStateException("Cannot enroll to self-created course.");
        }

        if (!course.getStatus().equals(Status.PUBLISHED)) {
            throw new IllegalStateException("Cannot enroll in a non-published course.");
        }

        if (course.getEnrolledUsers().contains(user)) {
            throw new IllegalStateException("User is already enrolled to the course. ");
        }
        course.addEnrolledUser(user);
        courseRepository.save(course);
    }

    private String saveFile(MultipartFile file, Long courseId) {
        try {
            validateFile(file);
            Path baseDir = Paths.get(uploadDir);
            if (!Files.exists(baseDir)) {
                Files.createDirectories(baseDir);
            }
            Path courseDir = baseDir.resolve(String.valueOf(courseId));
            if (!Files.exists(courseDir)) {
                Files.createDirectories(courseDir);
            } else {
                Files.list(courseDir)
                        .filter(Files::isRegularFile)
                        .forEach(filePath -> {
                            try {
                                Files.delete(filePath);
                            } catch (IOException e) {
                                throw new RuntimeException("Failed to delete existing file: " + filePath, e);
                            }
                        });
            }
            String fileName = MessageFormat.format("course_{0}_{1}", courseId, file.getOriginalFilename());
            Path filePath = courseDir.resolve(fileName);
            Files.deleteIfExists(filePath);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toString();

        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileStorageException("Cannot upload an empty file");
        }
        if (file.getSize() > 10*1024*1024) {
            throw new FileStorageException("File size exceeds maximum limit");
        }
        var contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            throw new FileStorageException("Invalid content type: " + contentType);
        }
    }

    private User getCurrentAuthenticatedUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return (User) authentication.getPrincipal();
        }
        throw new IllegalArgumentException("Unauthorized access: No valid user context found");
    }

}
