package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Record: CourseUpdateDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseUpdateDto(

        @NotBlank(message = "Title is required")
        @Size(min = 10, max = 100, message = "Title must be between 10 and 100 characters")
        String title,

        @NotBlank(message = "Description is required")
        String description,

        @NotNull(message = "Difficulty level is required")
        DifficultyLevel difficultyLevel,

        @NotNull(message = "Topic ID is required")
        Long topicId
) {

}
