package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.Status;
import jakarta.validation.constraints.NotNull;

/**
 * Record: CourseStatusUpdate
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseStatusUpdateDto(@NotNull(message = "Status is required") Status status) {
}
