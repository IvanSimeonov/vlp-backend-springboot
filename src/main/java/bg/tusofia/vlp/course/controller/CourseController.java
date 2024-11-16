package bg.tusofia.vlp.course.controller;

import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseOverviewDto;
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

}
