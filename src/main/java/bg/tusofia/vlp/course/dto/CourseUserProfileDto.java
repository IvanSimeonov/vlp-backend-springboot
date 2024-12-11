package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;

/**
 * Record: CourseUserProfileDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseUserProfileDto(
        Long id,
        String title,
        DifficultyLevel difficultyLevel,
        String topic,
        String author
) {
}
