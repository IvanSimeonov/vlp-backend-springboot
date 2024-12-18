package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.course.domain.Status;

/**
 * Record: CourseSearchCriteriaDto
 * <p>
 * A data transfer object (DTO) that encapsulates search parameters for filtering
 * and querying courses based on multiple criteria.
 * <p>
 * Enables flexible and comprehensive course searches by supporting filtering on:
 * <ul>
 *   <li>Course title</li>
 *   <li>Author name</li>
 *   <li>Difficulty level</li>
 *   <li>Course status</li>
 *   <li>Topic</li>
 * </ul>
 *
 * @param title Optional partial or full course title for searching
 * @param authorName Optional name of the course creator
 * @param difficultyLevel Optional difficulty level filter
 * @param status Optional course status filter
 * @param topic Optional topic filter
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseSearchCriteriaDto(String title, String authorName, DifficultyLevel difficultyLevel, Status status, String topic) {
}
