package bg.tusofia.vlp.assignment.controller;

import bg.tusofia.vlp.assignment.dto.AssignmentSolutionCreateDto;
import bg.tusofia.vlp.assignment.dto.AssignmentSolutionDto;
import bg.tusofia.vlp.assignment.service.AssignmentSolutionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Class: AssignmentSolutionController
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/v1/assignment")
@RequiredArgsConstructor
public class AssignmentSolutionController {

    private final AssignmentSolutionService assignmentSolutionService;

    @GetMapping(value = "/course/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssignmentSolutionDto>> getAllSolutionsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(assignmentSolutionService.getAllSolutionsByCourseId(courseId));
    }

    @GetMapping(value = "/lecture/{lectureId}/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssignmentSolutionDto> getSolutionByLectureAndUser(@PathVariable Long lectureId, @PathVariable Long userId) {
        return ResponseEntity.ok(assignmentSolutionService.getSolutionByLectureAndUser(lectureId, userId));
    }

    @GetMapping(value = "/course/{courseId}/user/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssignmentSolutionDto>> getAllSolutionsByCourseAndUser(@PathVariable Long courseId, @PathVariable Long userId) {
        return ResponseEntity.ok(assignmentSolutionService.getAllSolutionsByCourseAndUser(courseId, userId));
    }

    @GetMapping("/{assignmentSolutionId}/download")
    public ResponseEntity<Resource> downloadAssignmentSolution(@PathVariable Long assignmentSolutionId){
        Resource fileResource = assignmentSolutionService.getAssignmentSolutionFile(assignmentSolutionId);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileResource.getFilename() + "\"")
                .body(fileResource);
    }

    @Operation(
            summary = "Upload an assignment solution",
            description = "Uploads an assignment solution for a lecture by its id"
    )
    @PostMapping(value = "/{lectureId}/assignments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AssignmentSolutionDto> uploadAssignmentSolution(@PathVariable Long lectureId, @RequestPart @NotNull MultipartFile file) {
        AssignmentSolutionCreateDto assignmentSolutionCreateDto = new AssignmentSolutionCreateDto(lectureId, file);
        return ResponseEntity.ok(assignmentSolutionService.uploadAssignmentSolution(assignmentSolutionCreateDto));
    }

    @PutMapping("/{lectureId}/assignments/{assignmentSolutionId}")
    public ResponseEntity<Void> updateGradeSolution(@PathVariable Long lectureId, @PathVariable Long assignmentSolutionId, @RequestParam Integer grade) {
        assignmentSolutionService.gradeAssignmentSolution(assignmentSolutionId, grade);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{lectureId}/assignments/{assignmentSolutionId}")
    public ResponseEntity<Void> deleteAssignmentSolution(@PathVariable Long lectureId, @PathVariable Long assignmentSolutionId ) {
        assignmentSolutionService.deleteAssignmentSolution(assignmentSolutionId);
        return ResponseEntity.noContent().build();
    }
}
