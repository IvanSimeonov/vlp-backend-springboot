package bg.tusofia.vlp.course.service;

import bg.tusofia.vlp.course.dto.*;
import bg.tusofia.vlp.courserating.dto.CourseRatingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    Page<CourseManagementDto> getCourses(CourseSearchCriteriaDto criteria, PageRequest pageRequest);

    Page<CourseOverviewDto> getAllCourses(Pageable pageable);

    Page<CourseOverviewDto> getAllCoursesByTopic(Long topicId, Pageable pageable);

    void updateCourseById(Long courseId, CourseUpdateDto courseUpdateDto);

    /**
     * Allows a user to rate a course they have completed
     * @param courseId The ID of the course to be rated
     * @param courseRatingDto The dto containing rating information
     * @return The created CourseRatingDto
     * @throws IllegalArgumentException If the user has not completed the course or already rated it
     * @throws bg.tusofia.vlp.exception.CourseNotFoundException if the course is not found
     * @throws bg.tusofia.vlp.exception.UserNotFoundException if the user is not found
     */
    CourseRatingDto rateCourse(Long courseId, CourseRatingDto courseRatingDto);


    /**
     * Updates the status of a course.
     *
     * @param courseId the ID of the course to update.
     * @param courseStatusUpdateDto the status update details.
     */
    void updateCourseStatus(Long courseId, CourseStatusUpdateDto courseStatusUpdateDto);

    void deleteCourseById(Long courseId);

    void enrollUserToCourse(Long courseId, Long userId);
}
