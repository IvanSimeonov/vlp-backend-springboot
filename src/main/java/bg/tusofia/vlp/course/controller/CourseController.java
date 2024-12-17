package bg.tusofia.vlp.course.controller;

import bg.tusofia.vlp.course.dto.*;
import bg.tusofia.vlp.course.service.CourseService;
import bg.tusofia.vlp.courserating.dto.CourseRatingDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Class: CourseController
 * <p>
 * This controller handles all course-related operations.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    public ResponseEntity<CourseOverviewDto> getCourseOverviewById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(courseService.getCourseOverviewById(id));
    }

    @GetMapping("/topic/{topicId}")
    public ResponseEntity<Page<CourseOverviewDto>> getCourseOverviewByTopicId(@PathVariable(name = "topicId") Long topicId, Pageable pageable) {
        return ResponseEntity.ok(courseService.getAllCoursesByTopic(topicId, pageable));
    }

    @Operation(
            summary = "Get Course Analytics",
            description = "Returns a list of course analytics",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully retrieved course analytics",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = CourseAnalyticsDto.class)
                                    )
                            )
                    )
            }
    )
    @GetMapping("/analytics")
    public ResponseEntity<List<CourseAnalyticsDto>> getCourseAnalytics() {
        return ResponseEntity.ok(courseService.getCourseAnalytics());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CourseManagementDto>> getCourseManagementOverview(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            CourseSearchCriteriaDto courseSearchCriteriaDto) {
        PageRequest pageRequest = PageRequest.of(
                pageNumber,
                pageSize,
                sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending()
        );
        return ResponseEntity.ok(courseService.getCourses(courseSearchCriteriaDto, pageRequest));
    }

    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody @Valid CourseCreateDto courseCreateDto) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(courseService.createCourse(courseCreateDto))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/{courseId}/rate")
    public ResponseEntity<CourseRatingDto> rateCourseById(@PathVariable("courseId") Long courseId, @Valid @RequestBody CourseRatingDto courseRatingDto) {
        return ResponseEntity.ok(courseService.rateCourse(courseId, courseRatingDto));
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Void> updateCourseById(@PathVariable Long courseId, @RequestBody @Valid CourseUpdateDto courseUpdateDto) {
        courseService.updateCourseById(courseId, courseUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{courseId}/status")
    public ResponseEntity<Void> updateCourseStatusById(@PathVariable Long courseId, @RequestBody @Valid CourseStatusUpdateDto courseStatusUpdateDto) {
        courseService.updateCourseStatus(courseId, courseStatusUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{courseId}/enroll/{userId}")
    public ResponseEntity<Void> enrollUserToCourse(@PathVariable Long courseId, @PathVariable Long userId) {
        courseService.enrollUserToCourse(courseId, userId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long courseId) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

}
