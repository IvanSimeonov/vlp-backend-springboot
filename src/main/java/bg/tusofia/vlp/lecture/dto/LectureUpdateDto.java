package bg.tusofia.vlp.lecture.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Record: LectureUpdateDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record LectureUpdateDto(
        @NotBlank(message = "Title is required")
        @Size(min = 10, max = 100, message = "Title must be in range between 10 and 100 characters")
        String title,

        @NotBlank(message = "Short description is required")
        @Size(min = 100, max = 300, message = "Short description must be in range between 100 and 300 characters")
        String shortDescription,

        @NotBlank(message = "Full description is required")
        @Size(min = 10, max = 100, message = "Title must be in range between 300 and 1000 characters")
        String fullDescription,

        @NotBlank(message = "Video URL is required")
        @Pattern(regexp = "^https?://.*", message = "Video URL must be a valid URL")
        String videoUrl,

        @Positive(message = "Sequence number must be positive")
        int sequenceNumber) {
}
