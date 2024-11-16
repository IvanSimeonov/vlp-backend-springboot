package bg.tusofia.vlp.course.service;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseOverviewDto;
import bg.tusofia.vlp.course.mapper.CourseMapper;
import bg.tusofia.vlp.course.repository.CourseRepository;
import bg.tusofia.vlp.topic.repository.TopicRepository;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return null;
    }

    @Override
    public Page<CourseOverviewDto> getAllCoursesByTopic(Long topicId, Pageable pageable) {
        return courseRepository.findCourseOverviewByTopic(topicRepository.getReferenceById(topicId), pageable)
                .map(courseMapper::courseOverviewToCourseOverviewDto);
    }
}
