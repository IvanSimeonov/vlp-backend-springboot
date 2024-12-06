package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;

/**
 * Record: CourseAnalyticsDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseAnalyticsDto(DifficultyLevel difficultyLevel, long totalCourses) {
}
