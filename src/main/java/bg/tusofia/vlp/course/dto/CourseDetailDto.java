package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.user.dto.UserBasicDto;

/**
 * Record: CourseDetailDto
 * <p>
 * A data transfer object (DTO) that contain comprehensive information about the {@link bg.tusofia.vlp.course.domain.Course}
 * entity, including specific details. Used to display individual course.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseDetailDto(Long id, String title, DifficultyLevel difficultyLevel, UserBasicDto author) {
}
