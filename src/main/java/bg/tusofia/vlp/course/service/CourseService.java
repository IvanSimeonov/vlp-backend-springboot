package bg.tusofia.vlp.course.service;

import bg.tusofia.vlp.course.dto.*;
import bg.tusofia.vlp.courserating.dto.CourseRatingDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

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

    Page<CourseOverviewDto> getPagedCourseOverviews(CourseSearchCriteriaDto criteria, PageRequest pageRequest);

    /**
     * Retrieves the top 10 courses with the most students enrolled or completed.
     * @return List of top 10 courses sorted by total student count in descending order.
     */
    List<CourseOverviewDto> getTopCoursesByStudentCount();

    /**
     * Retrieves a paginated list of courses created by the current user.
     *
     * @param searchCriteria The search criteria for filtering courses
     * @param pageRequest Pagination and sorting configuration
     * @return A page of course overview DTOs matching the search criteria
     * @throws IllegalArgumentException if search criteria or page request is invalid
     */
    Page<CourseOverviewDto> getUserCreatedCourses(
            CourseSearchCriteriaDto searchCriteria,
            PageRequest pageRequest
    );

    /**
     * Retrieves a paginated list of courses enrolled by the current user.
     *
     * @param searchCriteria The search criteria for filtering courses
     * @param pageRequest Pagination and sorting configuration
     * @return A page of course overview DTOs matching the search criteria
     * @throws IllegalArgumentException if search criteria or page request is invalid
     */
    Page<CourseOverviewDto> getUserEnrolledCourses(
            CourseSearchCriteriaDto searchCriteria,
            PageRequest pageRequest
    );

    /**
     * Retrieves a paginated list of courses completed by the current user.
     *
     * @param searchCriteria The search criteria for filtering courses
     * @param pageRequest Pagination and sorting configuration
     * @return A page of course overview DTOs matching the search criteria
     * @throws IllegalArgumentException if search criteria or page request is invalid
     */
    Page<CourseOverviewDto> getUserCompletedCourses(
            CourseSearchCriteriaDto searchCriteria,
            PageRequest pageRequest
    );

    void updateCourseById(Long courseId, CourseUpdateDto courseUpdateDto);

    /**
     * Allows a user to rate a course they have completed
     * @param courseId The ID of the course to be rated
     * @param courseRatingDto The dto containing rating information
     * @return The created CourseRatingDto
     * @throws bg.tusofia.vlp.exception.CourseAlreadyRatedException If the user has already rated the course
     * @throws bg.tusofia.vlp.exception.CourseNotCompletedException If the user has not completed the course
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

    void enrollUserToCourse(Long courseId);

    /**
     * Updates the course image for a specified course by uploading a new image file.
     * This method stores the uploaded file, saves the image path in the course,
     * and updates the course with the new image information.
     *
     * @param courseId the unique ID of the course, whose image is being updated
     * @param image the new image file to be uploaded and set as the courses image
     * @throws bg.tusofia.vlp.exception.CourseNotFoundException if no course exists with the specified {@code courseId}
     */
    void uploadCourseImage(long courseId, MultipartFile image);

}
