package bg.tusofia.vlp.courserating.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

/**
 * Record: CourseRatingDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseRatingDto(
        Long courseId,
        Long userId,
        @Min(value = 1, message = "Rating must be at least 1")
        @Max(value = 5, message = "Rating must be at most 5")
        Integer rating){
        }
