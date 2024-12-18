package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import jakarta.validation.constraints.*;

/**
 * Record: CourseUpdateDto
 * <p>
 * A data transfer object (DTO) that represents the data required to update an existing
 * {@link bg.tusofia.vlp.course.domain.Course} entity.
 * Used to capture and validate input data for course modification from the client.
 * <p>
 * Extends {@link CourseCreateDto} functionality by including the course identifier
 * for precise course updates, with comprehensive validation constraints.
 *
 * @param id The unique identifier of the course to be updated, must not be null
 * @param title The updated title of the course, required to be between 10 and 100 characters
 * @param shortDescription Updated brief overview of the course
 * @param passingScore Updated minimum score required to pass the course
 * @param topicId The updated topic identifier associated with the course
 * @param difficultyLevel The updated difficulty level of the course
 * @param requirements Updated prerequisite skills or knowledge needed
 * @param fullDescription Updated comprehensive description of the course content
 * @param authorId The identifier of the course creator
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseUpdateDto(

        @NotNull(message = "Course Id is required")
        Long id,

        @NotBlank(message = "Title is required")
        @Size(min = 10, max = 100, message = "Title must be between 10 and 100 characters")
        String title,

        @NotBlank(message = "Short description is required")
        @Size(min = 50, max = 300, message = "Short description must be between 50 and 300 characters")
        String shortDescription,

        @NotNull
        @Min(value = 50, message = "Passing score must be at least 50%")
        @Max(value = 100, message = "Passing score must be at most 100%")
        int passingScore,

        @NotNull(message = "Topic is required")
        Long topicId,

        @NotNull(message = "Difficulty level is required")
        DifficultyLevel difficultyLevel,

        @NotBlank(message = "Requirements are required")
        @Size(min = 50, max = 500, message = "Requirements must be between 50 and 500 characters")
        String requirements,

        @NotBlank(message = "Full description is required")
        @Size(min = 300, max = 3000, message = "Full description must be between 300 and 3000 characters")
        String fullDescription,

        @NotNull(message = "Author ID is required")
        Long authorId
) {

}
