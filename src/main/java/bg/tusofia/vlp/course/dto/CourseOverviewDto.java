package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.user.dto.UserOverviewDto;

/**
 * Record: CourseOverviewDto
 * <p>
 * A data transfer object (DTO) that represents a summarized view of the {@link bg.tusofia.vlp.course.domain.Course} entity.
 * Used to display for lists or search results.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseOverviewDto(
        Long id,
        String title,
        DifficultyLevel difficultyLevel,
        UserOverviewDto author,
        Double averageRating,
        Integer totalRatings) {
}
