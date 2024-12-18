package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;

/**
 * Record: CourseAnalyticsDto
 * <p>
 * A data transfer object (DTO) designed for aggregating and visualizing
 * course distribution statistics in administrative dashboards.
 * <p>
 * Provides a concise representation of course count grouped by difficulty level,
 * enabling easy generation of charts, graphs, and analytical insights.
 *
 * @param difficultyLevel The complexity classification of courses
 * @param totalCourses Number of courses within this difficulty level
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseAnalyticsDto(DifficultyLevel difficultyLevel, long totalCourses) {
}
