package bg.tusofia.vlp.assignment.mapper;

import bg.tusofia.vlp.assignment.domain.AssignmentSolution;
import bg.tusofia.vlp.assignment.dto.AssignmentSolutionCreateDto;
import bg.tusofia.vlp.assignment.dto.AssignmentSolutionDto;
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

    @Mapping(target = "lectureId", source = "lecture.id")
    @Mapping(target = "userId", source = "student.id")
    AssignmentSolutionDto assignmentSolutionToAssignmentSolutionDto(AssignmentSolution assignmentSolution);
}
