package bg.tusofia.vlp.course.service;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.domain.Status;
import bg.tusofia.vlp.course.dto.*;
import bg.tusofia.vlp.course.mapper.CourseMapper;
import bg.tusofia.vlp.course.repository.CourseRepository;
import bg.tusofia.vlp.course.repository.CourseSpecification;
import bg.tusofia.vlp.exception.CourseNotFoundException;
import bg.tusofia.vlp.exception.UserNotFoundException;
import bg.tusofia.vlp.topic.repository.TopicRepository;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private final CourseMapper courseMapper;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;

    @Override
    public Long createCourse(CourseCreateDto courseCreateDto) {
        Course course = this.courseMapper.courseCreateDtoToCourse(courseCreateDto);
        User author = userRepository.findById(courseCreateDto.authorId())
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id: " + courseCreateDto.authorId()));
        course.setAuthor(author);
        return courseRepository.save(course).getId();
    }

    @Override
    public CourseOverviewDto getCourseOverviewById(Long courseId) {
        var course = this.courseRepository.findCourseOverviewById(courseId);
        return this.courseMapper.courseOverviewToCourseOverviewDto(course);
    }

    @Override
    public Page<CourseOverviewDto> getAllCourses(Pageable pageable) {
        return courseRepository.findAllProjectedBy(pageable).map(courseMapper::courseOverviewToCourseOverviewDto);
    }

    @Override
    public Page<CourseManagementDto> getCourses(CourseSearchCriteriaDto criteria, PageRequest pageRequest) {
        var courses = courseRepository.findAll(CourseSpecification.getCoursesByCriteria(criteria), pageRequest);
        return courses.map(courseMapper::courseToCourseManagementDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CourseAnalyticsDto> getCourseAnalytics() {
        return courseRepository.findCourseAnalytics();
    }

    @Override
    public void updateCourseById(Long courseId, CourseUpdateDto courseUpdateDto) {
        var course = this.courseRepository.findCourseById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        course.setTitle(courseUpdateDto.title());
        course.setDescription(courseUpdateDto.description());
        course.setDifficultyLevel(courseUpdateDto.difficultyLevel());
        course.setTopic(topicRepository.getReferenceById(courseUpdateDto.topicId()));
        courseRepository.save(course);
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
        if (course.getLectures().isEmpty()) {
            throw new IllegalStateException("Cannot delete course with enrolled users.");
        }
        courseRepository.deleteById(courseId);
    }

    @Override
    public void enrollUserToCourse(Long courseId, Long userId) {
        var course = courseRepository.findCourseById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
        var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));

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

    @Override
    public Page<CourseOverviewDto> getAllCoursesByTopic(Long topicId, Pageable pageable) {
        return courseRepository.findCourseOverviewByTopic(topicRepository.getReferenceById(topicId), pageable)
                .map(courseMapper::courseOverviewToCourseOverviewDto);
    }
}
