package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.course.domain.Status;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;

/**
 * Record: CourseOverviewDto
 * <p>
 * A data transfer object (DTO) that provides a concise summary of a
 * {@link bg.tusofia.vlp.course.domain.Course} entity for various user-facing views.
 * <p>
 * Designed to efficiently display course information in contexts such as:
 * <ul>
 *   <li>Paged search results</li>
 *   <li>User profile views of created, enrolled, or completed courses</li>
 *   <li>Course listings and preview sections</li>
 * </ul>
 *
 * @param id               Unique identifier of the course
 * @param title            The title of the course
 * @param shortDescription A brief overview of the course content
 * @param author           Condensed information about the course creator
 * @param averageRating    The aggregate rating of the course
 * @param totalRatings     Total number of ratings received
 * @param topic            Overview of the course's primary topic
 * @param difficultyLevel  Difficulty classification of the course
 * @param imagePath        File path to the course's representative image
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseOverviewDto(
        Long id,
        String title,
        String shortDescription,
        UserOverviewDto author,
        Double averageRating,
        Integer totalRatings,
        TopicOverviewDto topic,
        DifficultyLevel difficultyLevel,
        String imagePath,
        Status status
) {
}
