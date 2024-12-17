package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Record: CourseCreateDto
 * <p>
 * A data transfer object (DTO) that represents the data required to create a new {@link bg.tusofia.vlp.course.domain.Course} entity.
 * Used to capture input data for course creation from the client, with validation constraints to ensure data integrity.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseCreateDto(

        @NotBlank(message = "Title is required")
        @Size(min = 10, max = 100, message = "Title must be between 10 and 100 characters")
        String title,

        @NotBlank(message = "Short Description is required")
        String shortDescription,

        int passingScore,

        @NotNull(message = "Topic ID is required")
        Long topicId,

        @NotNull(message = "Difficulty level is required")
        DifficultyLevel difficultyLevel,

        String requirements,

        String fullDescription,

        @NotNull(message = "Author ID is required")
        Long authorId
) {

}
