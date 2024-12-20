package bg.tusofia.vlp.course.controller;

import bg.tusofia.vlp.course.dto.*;
import bg.tusofia.vlp.course.service.CourseService;
import bg.tusofia.vlp.courserating.dto.CourseRatingDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    @Operation(
            summary = "Get Course Overview By Id",
            description = "Returns a course overview dto with limited details"
    )
    @GetMapping(value = "/{courseId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseOverviewDto> getCourseOverviewById(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getCourseOverviewById(courseId));
    }

    @Operation(
            summary = "Get Course Analytics",
            description = "Returns a list of course analytics"
    )
    @GetMapping(value = "/analytics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CourseAnalyticsDto>> getCourseAnalytics() {
        return ResponseEntity.ok(courseService.getCourseAnalytics());
    }

    @Operation(
            summary = "Get Course Management Overview",
            description = "Returns a page of course management overview dtos"
    )
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CourseManagementDto>> getCourseManagementOverview(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            CourseSearchCriteriaDto courseSearchCriteriaDto) {
        return ResponseEntity.ok(courseService.getCourses(courseSearchCriteriaDto, createPageRequest(pageNumber, pageSize, sortBy, sortDirection)));
    }

    @Operation(
            summary = "Get Course Overview",
            description = "Returns a page of course overview dtos"
    )
    @GetMapping(value = "/explore", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CourseOverviewDto>> getCourseOverview(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            CourseSearchCriteriaDto courseSearchCriteriaDto) {
        return ResponseEntity.ok(courseService.getPagedCourseOverviews(courseSearchCriteriaDto, createPageRequest(pageNumber, pageSize, sortBy, sortDirection)));
    }

    @Operation(
            summary = "Get Course Image",
            description = "Returns the image of a course"
    )
    @GetMapping(value = "/course-image", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    public ResponseEntity<Resource> getCourseImage(@RequestParam String filePath) {
        try {
            Path imagePath = Paths.get("").resolve(filePath).normalize();
            Resource resource = new UrlResource(imagePath.toUri());

            if (resource.exists() && resource.isReadable()) {
                String fileExtension = getFileExtension(filePath);
                MediaType mediaType = switch (fileExtension) {
                    case "png" -> MediaType.IMAGE_PNG;
                    case "gif" -> MediaType.IMAGE_GIF;
                    default -> MediaType.IMAGE_JPEG;
                };
                return ResponseEntity.ok()
                        .contentType(mediaType)
                        .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(
            summary = "Get Top Courses By Student Count",
            description = "Returns the top 10 featured courses with most enrolled and completed students"
    )
    @GetMapping(value = "/featured", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CourseOverviewDto>> getTopCoursesByStudentCount() {
        return ResponseEntity.ok(courseService.getTopCoursesByStudentCount());
    }

    @Operation(
            summary = "Get Users Created Courses",
            description = "Returns the courses that the currently logged user has created with pagination, sorting and filtering."
    )
    @GetMapping(value = "/learnings/created", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CourseOverviewDto>> getUsersCreatedCourses(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            CourseSearchCriteriaDto courseSearchCriteriaDto) {
        return ResponseEntity.ok(courseService.getUserCreatedCourses(courseSearchCriteriaDto, createPageRequest(pageNumber, pageSize, sortBy, sortDirection)));
    }

    @Operation(
            summary = "Get Users Enrolled Courses",
            description = "Returns the courses that the currently logged user has enrolled in with pagination, sorting and filtering."
    )
    @GetMapping(value = "/learnings/enrolled", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CourseOverviewDto>> getUserEnrolledCourses(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            CourseSearchCriteriaDto courseSearchCriteriaDto) {
        return ResponseEntity.ok(courseService.getUserEnrolledCourses(courseSearchCriteriaDto, createPageRequest(pageNumber, pageSize, sortBy, sortDirection)));
    }

    @Operation(
            summary = "Get Users Completed Courses",
            description = "Returns the courses that the currently logged user has completed with pagination, sorting and filtering."
    )
    @GetMapping(value = "/learnings/completed", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CourseOverviewDto>> getUsersCompletedCourses(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            CourseSearchCriteriaDto courseSearchCriteriaDto) {
        return ResponseEntity.ok(courseService.getUserCompletedCourses(courseSearchCriteriaDto, createPageRequest(pageNumber, pageSize, sortBy, sortDirection)));
    }

    @Operation(
            summary = "Get Course Details By Id",
            description = "Returns detailed information about course by id"
    )
    @GetMapping(value = "/{courseId}/details", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseDetailsDto> getCourseDetailsById(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseService.getCourseDetailsById(courseId));
    }


    @Operation(
            summary = "Create Course",
            description = "Creates a new course"
    )
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> createCourse(@RequestBody @Valid CourseCreateDto courseCreateDto) {
        return ResponseEntity.ok(courseService.createCourse(courseCreateDto));
    }

    @Operation(
            summary = "Rate Course By Id",
            description = "Rates a course by its id when the user has successfully completed the course"
    )
    @PostMapping(value = "/{courseId}/rate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseRatingDto> rateCourseById(@PathVariable Long courseId, @Valid @RequestBody CourseRatingDto courseRatingDto) {
        return ResponseEntity.ok(courseService.rateCourse(courseId, courseRatingDto));
    }

    @Operation(
            summary = "Enroll User To Course",
            description = "User enrolls to a course by its id"
    )
    @PostMapping("/{courseId}/enroll")
    public ResponseEntity<Void> enrollUserToCourse(@PathVariable Long courseId) {
        courseService.enrollUserToCourse(courseId);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Update Course By Id",
            description = "Updates the course"
    )
    @PutMapping("/{courseId}")
    public ResponseEntity<Void> updateCourseById(@PathVariable Long courseId, @RequestBody @Valid CourseUpdateDto courseUpdateDto) {
        courseService.updateCourseById(courseId, courseUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Update Course Status By Id",
            description = "Updates the course status by course id"
    )
    @PutMapping("/{courseId}/status")
    public ResponseEntity<Void> updateCourseStatusById(@PathVariable Long courseId, @RequestBody @Valid CourseStatusUpdateDto courseStatusUpdateDto) {
        courseService.updateCourseStatus(courseId, courseStatusUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Upload Course Image",
            description = "Uploads an image to the course by its id"
    )
    @PutMapping(value = "/{courseId}/upload-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> uploadCourseImage(
            @PathVariable Long courseId,
            @RequestPart @NotNull MultipartFile file) {
        courseService.uploadCourseImage(courseId, file);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Delete Course By Id",
            description = "Deletes a course by its id"
    )
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable Long courseId) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }

    private String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0) {
            return fileName.substring(lastDotIndex + 1);
        }
        return "";
    }

    private PageRequest createPageRequest(int pageNumber, int pageSize, String sortBy, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        return PageRequest.of(pageNumber, pageSize, sort);
    }

}
