package bg.tusofia.vlp.assignment.dto;

import org.springframework.web.multipart.MultipartFile;

/**
 * Record: AssignmentSolutionCreateDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record AssignmentSolutionCreateDto(Long lectureId, MultipartFile file) {
}
