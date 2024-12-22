package bg.tusofia.vlp.assignment.dto;

/**
 * Record: AssignmentSolutionDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record AssignmentSolutionDto (
        Long id,
        Long lectureId,
        Long userId,
        Integer grade,
        String submissionFilePath
) {
}
