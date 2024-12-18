package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import jakarta.validation.constraints.*;

/**
 * Record: CourseCreateDto
 * <p>
 * A data transfer object (DTO) that represents the data required to create a new {@link bg.tusofia.vlp.course.domain.Course} entity.
 * Used to capture input data for course creation from the client, with validation constraints to ensure data integrity.
 * <p>
 * Validates and transfers essential course details including title, description,
 * passing score, topic, difficulty level, requirements, and author information.
 *
 * @param title The title of the course, required to be between 10 and 100 characters
 * @param shortDescription A brief overview of the course, required to be between 50 and 300 characters
 * @param passingScore The minimum score required to pass the course, between 50% and 100%
 * @param topicId The identifier of the topic associated with the course
 * @param difficultyLevel The difficulty level of the course
 * @param requirements Prerequisite skills or knowledge needed for the course
 * @param fullDescription Comprehensive description of the course content
 * @param authorId The identifier of the course creator
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseCreateDto(

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
