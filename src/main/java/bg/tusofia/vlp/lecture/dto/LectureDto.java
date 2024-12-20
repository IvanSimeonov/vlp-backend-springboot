package bg.tusofia.vlp.lecture.dto;

import jakarta.validation.constraints.*;

/**
 * Record: LectureDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record LectureDto(
        Long id,

        @NotBlank(message = "Title is required")
        @Size(min = 10, max = 100, message = "Title must be in range between 10 and 100 characters")
        String title,

        @NotBlank(message = "Description is required")
        @Size(min = 100, max = 500, message = "Description must be in range between 100 and 500 characters")
        String description,

        @NotBlank(message = "Video URL is required")
        @Pattern(regexp = "^https?://.*", message = "Video URL must be a valid URL")
        String videoUrl,

        @NotBlank(message = "Assignment task is required")
        @Size(min = 100, max = 500, message = "Assignment task must be in range between 100 and 500 characters")
        String assignmentTask,

        @Positive(message = "Sequence number must be positive")
        int sequenceNumber,

        @NotNull(message = "Course ID is required")
        Long courseId
) {
}
