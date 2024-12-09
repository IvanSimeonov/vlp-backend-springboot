package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.course.domain.Status;

/**
 * Record: CourseSearchCriteriaDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseSearchCriteriaDto(String title, String authorName, DifficultyLevel difficultyLevel, Status status, String topic) {
}
