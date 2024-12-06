package bg.tusofia.vlp.course.service;

import bg.tusofia.vlp.course.domain.Status;
import bg.tusofia.vlp.course.dto.CourseAnalyticsDto;
import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseOverviewDto;
import bg.tusofia.vlp.course.dto.CourseUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interface: CourseService
 * <p>
 * Service interface for managing course-related operations. Provides methods that will be
 * implemented to interact with course data at the service level.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface CourseService {
    Long createCourse(CourseCreateDto courseCreateDto);

    CourseOverviewDto getCourseOverviewById(Long courseId);

    /**
     * Retrieves a list of course analytics, where we can see the amount of courses per difficulty level.
     *
     * @return a list of {@link bg.tusofia.vlp.course.dto.CourseAnalyticsDto} objects
     *         Note: This method can only be called by an admin user.
     */
    List<CourseAnalyticsDto> getCourseAnalytics();

    Page<CourseOverviewDto> getAllCourses(Pageable pageable);

    Page<CourseOverviewDto> getAllCoursesByTopic(Long topicId, Pageable pageable);

    void updateCourseById(Long courseId, CourseUpdateDto courseUpdateDto);

    void updateCourseStatus(Long courseId, Status status);

    void deleteCourseById(Long courseId);

    void enrollUserToCourse(Long courseId, Long userId);
}
