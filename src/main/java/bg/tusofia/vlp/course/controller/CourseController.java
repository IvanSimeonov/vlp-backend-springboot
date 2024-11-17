package bg.tusofia.vlp.course.controller;

import bg.tusofia.vlp.course.domain.Status;
import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseOverviewDto;
import bg.tusofia.vlp.course.dto.CourseUpdateDto;
import bg.tusofia.vlp.course.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<Void> createCourse(@RequestBody @Valid CourseCreateDto courseCreateDto) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(courseService.createCourse(courseCreateDto))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<Void> updateCourseById(@PathVariable Long courseId, @RequestBody @Valid CourseUpdateDto courseUpdateDto) {
        courseService.updateCourseById(courseId, courseUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{courseId}/status-update")
    public ResponseEntity<Void> updateCourseStatus(@PathVariable Long courseId, @RequestParam Status status) {
        courseService.updateCourseStatus(courseId, status);
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
