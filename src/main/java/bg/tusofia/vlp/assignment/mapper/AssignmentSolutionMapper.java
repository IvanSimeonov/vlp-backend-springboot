package bg.tusofia.vlp.assignment.mapper;

import bg.tusofia.vlp.assignment.domain.AssignmentSolution;
import bg.tusofia.vlp.assignment.dto.AssignmentSolutionCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Interface: AssignmentSolutionMapper
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Mapper
public interface AssignmentSolutionMapper {

    @Mapping(target = "submissionFilePath", ignore = true)
    AssignmentSolution assignmentSolutionCreateDtoToAssignmentSolution(AssignmentSolutionCreateDto assignmentSolutionCreateDto);
}
