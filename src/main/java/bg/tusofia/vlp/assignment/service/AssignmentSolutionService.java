package bg.tusofia.vlp.assignment.service;

import bg.tusofia.vlp.assignment.dto.AssignmentSolutionCreateDto;
import org.springframework.core.io.Resource;

/**
 * Interface: AssignmentSolutionService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface AssignmentSolutionService {
    Resource getAssignmentSolutionFile(Long assignmentSolutionId);
    void uploadAssignmentSolution(AssignmentSolutionCreateDto assignmentSolutionCreateDto);
    void deleteAssignmentSolution(Long assignmentSolutionId);
    void gradeAssignmentSolution(Long assignmentSolutionId, Integer grade);
}
