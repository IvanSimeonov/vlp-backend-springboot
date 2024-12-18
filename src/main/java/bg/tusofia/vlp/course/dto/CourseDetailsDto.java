package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;

/**
 * Record: CourseDetailsDto
 * <p>
 * A comprehensive data transfer object (DTO) that encapsulates detailed information
 * about a {@link bg.tusofia.vlp.course.domain.Course} entity.
 * <p>
 * Designed to provide an in-depth view of a course, including:
 * <ul>
 *   <li>Basic course information</li>
 *   <li>Descriptive content</li>
 *   <li>Author and topic details</li>
 *   <li>Performance and rating metrics</li>
 *   <li>Structural information</li>
 * </ul>
 * Primarily used for displaying individual course pages and detailed course views.
 *
 * @param id Unique identifier of the course
 * @param title The title of the course
 * @param shortDescription Brief overview of the course
 * @param fullDescription Comprehensive description of the course content
 * @param requirements Prerequisite skills or knowledge needed
 * @param averageRating Aggregate rating of the course
 * @param totalRatings Number of ratings received
 * @param author Condensed information about the course creator
 * @param topicOverviewDto Overview of the course's primary topic
 * @param difficultyLevel Complexity classification of the course
 * @param imagePath File path to the course's representative image
 * @param totalLecture Number of lectures in the course
 * @param totalAssignments Number of assignments in the course
 * @param passingScore Minimum score required to complete the course
 * @param modificationDate Date of the most recent course modification
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseDetailsDto(
        Long id,
        String title,
        String shortDescription,
        String fullDescription,
        String requirements,
        Double averageRating,
        Integer totalRatings,
        UserOverviewDto author,
        TopicOverviewDto topicOverviewDto,
        DifficultyLevel difficultyLevel,
        String imagePath,
        int totalLectures,
        int totalAssignments,
        int passingScore,
        String modificationDate
) {
}
