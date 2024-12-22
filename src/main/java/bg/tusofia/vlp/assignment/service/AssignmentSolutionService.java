package bg.tusofia.vlp.assignment.service;

import bg.tusofia.vlp.assignment.dto.AssignmentSolutionCreateDto;
import bg.tusofia.vlp.assignment.dto.AssignmentSolutionDto;
import org.springframework.core.io.Resource;

import java.util.List;

/**
 * Interface: AssignmentSolutionService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface AssignmentSolutionService {
    AssignmentSolutionDto getSolutionByLectureAndUser(Long lectureId, Long userId);
    List<AssignmentSolutionDto> getAllSolutionsByCourseAndUser(Long courseId, Long userId);
    Resource getAssignmentSolutionFile(Long assignmentSolutionId);
    AssignmentSolutionDto uploadAssignmentSolution(AssignmentSolutionCreateDto assignmentSolutionCreateDto);
    void deleteAssignmentSolution(Long assignmentSolutionId);
    void gradeAssignmentSolution(Long assignmentSolutionId, Integer grade);
}
