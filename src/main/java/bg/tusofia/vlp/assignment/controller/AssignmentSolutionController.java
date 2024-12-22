package bg.tusofia.vlp.assignment.controller;

import bg.tusofia.vlp.assignment.dto.AssignmentSolutionCreateDto;
import bg.tusofia.vlp.assignment.dto.AssignmentSolutionDto;
import bg.tusofia.vlp.assignment.service.AssignmentSolutionService;
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

    @GetMapping("/lecture/{lectureId}/user/{userId}")
    public ResponseEntity<AssignmentSolutionDto> getSolutionByLectureAndUser(@PathVariable Long lectureId, @PathVariable Long userId) {
        return ResponseEntity.ok(assignmentSolutionService.getSolutionByLectureAndUser(lectureId, userId));
    }

    @GetMapping("/course/{courseId}/user/{userId}")
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

    @PostMapping("/{lectureId}/assignments")
    public ResponseEntity<Void> uploadAssignmentSolution(@PathVariable Long lectureId, @RequestParam MultipartFile file) {
        AssignmentSolutionCreateDto assignmentSolutionCreateDto = new AssignmentSolutionCreateDto(lectureId, file);
        assignmentSolutionService.uploadAssignmentSolution(assignmentSolutionCreateDto);
        return ResponseEntity.ok().build();
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
