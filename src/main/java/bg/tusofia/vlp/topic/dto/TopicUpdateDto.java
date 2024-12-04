package bg.tusofia.vlp.topic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Record: TopicUpdateDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record TopicUpdateDto(
        @NotBlank(message = "Topic ID is required")
        Long id,

        @NotBlank(message = "Topic title is required")
        @Size(min = 5, max = 50, message = "Topic title must be between 5 and 50 characters")
        String title,

        @Size(min = 20, max = 100, message = "Topic description must be between 20 and 100 characters")
        String description) {
}
