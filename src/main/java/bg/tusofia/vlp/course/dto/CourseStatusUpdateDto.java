package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.Status;
import jakarta.validation.constraints.NotNull;

/**
 * Record: CourseStatusUpdateDto
 * <p>
 * A data transfer object (DTO) specifically designed for updating
 * the administrative status of a course.
 * <p>
 * Provides a focused, validated mechanism for changing a course's
 * current status in the system, ensuring only valid status transitions.
 *
 * @param status The new status to be applied to the course,
 *               required and cannot be null
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseStatusUpdateDto(
        @NotNull(message = "Status is required")
        Status status) {
}
