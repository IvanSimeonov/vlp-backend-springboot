package bg.tusofia.vlp.lecture.service;

import bg.tusofia.vlp.course.repository.CourseRepository;
import bg.tusofia.vlp.exception.CourseNotFoundException;
import bg.tusofia.vlp.exception.LectureNotFoundException;
import bg.tusofia.vlp.lecture.domain.Lecture;
import bg.tusofia.vlp.lecture.dto.LectureDetailDto;
import bg.tusofia.vlp.lecture.dto.LectureDto;
import bg.tusofia.vlp.lecture.dto.LectureOverviewDto;
import bg.tusofia.vlp.lecture.mapper.LectureMapper;
import bg.tusofia.vlp.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Class: LectureServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@Transactional
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final LectureMapper lectureMapper;
    private final CourseRepository courseRepository;

    @Override
    public LectureDetailDto getLectureDetailsById(Long lectureId) {
        return this.lectureMapper.lectureDetailToLectureDetailDto(
                this.lectureRepository.findLectureDetailById(lectureId)
                        .orElseThrow(() -> new LectureNotFoundException(lectureId))
        );
    }

    @Override
    public List<LectureOverviewDto> getAllLectureOverviewByCourseId(Long courseId) {
        return lectureRepository.findAllLectureOverviewByCourseIdOrderBySequenceNumber(courseId)
                .stream()
                .map(lectureMapper::lectureOverviewToLectureOverviewDto)
                .toList();
    }

    @Override
    public List<LectureDetailDto> getAllLectureDetailByCourseId(Long courseId) {
        return lectureRepository.findAllLectureDetailsByCourseIdOrderBySequenceNumber(courseId)
                .stream()
                .map(lectureMapper::lectureDetailToLectureDetailDto)
                .toList();
    }

    @Override
    public LectureDto createUpdateLecture(LectureDto lectureDto) {
        var lecture = lectureDto.id() != null
                ? lectureRepository.findLectureById(lectureDto.id()).orElseThrow(() -> new LectureNotFoundException((lectureDto.id())))
                : new Lecture();
        lecture.setTitle(lectureDto.title());
        lecture.setDescription(lectureDto.description());
        lecture.setVideoUrl(lectureDto.videoUrl());
        lecture.setAssignmentTask(lectureDto.assignmentTask());
        lecture.setSequenceNumber(lectureDto.sequenceNumber());
        var course = courseRepository.getReferenceById(lectureDto.courseId());
        lecture.setCourse(course);
        return lectureMapper.lectureToLectureDto(lectureRepository.save(lecture));
    }

    @Override
    public List<LectureDto> createUpdateLectures(Long courseId, List<LectureDto> lectureDtos) {
        var course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        var existingLectures = new HashSet<>(lectureRepository.findAllByCourseId(courseId));
        var lecturesToUpdate = new HashSet<Long>();
        var incomingLectures = new HashSet<Lecture>();

        for (LectureDto lectureDto : lectureDtos) {
            if (lectureDto.id() != null) {
                var lecture = existingLectures.stream()
                        .filter(lec -> lec.getId().equals(lectureDto.id()))
                        .findFirst()
                        .orElseThrow(() -> new LectureNotFoundException(lectureDto.id()));
                lecture.setTitle(lectureDto.title());
                lecture.setDescription(lectureDto.description());
                lecture.setVideoUrl(lectureDto.videoUrl());
                lecture.setAssignmentTask(lectureDto.assignmentTask());
                lecture.setSequenceNumber(lectureDto.sequenceNumber());
                incomingLectures.add(lecture);
                lecturesToUpdate.add(lecture.getId());
            } else {
                var newLecture = Lecture.builder()
                        .title(lectureDto.title())
                        .description(lectureDto.description())
                        .videoUrl(lectureDto.videoUrl())
                        .assignmentTask(lectureDto.assignmentTask())
                        .sequenceNumber(lectureDto.sequenceNumber())
                        .course(course)
                        .build();
                incomingLectures.add(newLecture);
            }
        }
        var lecturesToDelete = existingLectures.stream()
                .filter(lecture -> !lecturesToUpdate.contains(lecture.getId()))
                .toList();
        lectureRepository.deleteAll(lecturesToDelete);
        var savedLectures = lectureRepository.saveAll(incomingLectures);
        return savedLectures.stream()
                .map(lectureMapper::lectureToLectureDto)
                .sorted(Comparator.comparingInt(LectureDto::sequenceNumber))
                .toList();
    }

    @Override
    public void deleteLecture(Long lectureId) {
        lectureRepository.deleteById(lectureId);
    }
}
