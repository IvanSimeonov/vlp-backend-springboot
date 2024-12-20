package bg.tusofia.vlp.lecture.controller;

import bg.tusofia.vlp.lecture.dto.LectureCreateDto;
import bg.tusofia.vlp.lecture.dto.LectureDetailDto;
import bg.tusofia.vlp.lecture.dto.LectureOverviewDto;
import bg.tusofia.vlp.lecture.dto.LectureUpdateDto;
import bg.tusofia.vlp.lecture.service.LectureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Class: LectureController
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = "/api/v1/lecture", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @GetMapping("/{lectureId}")
    public ResponseEntity<LectureDetailDto> getLectureDetailById(@PathVariable Long lectureId) {
        return ResponseEntity.ok(this.lectureService.getLectureDetailById(lectureId));
    }

    @GetMapping("/{courseId}/overview")
    public ResponseEntity<List<LectureOverviewDto>> getAllLectureOverviewByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(this.lectureService.getAllLectureOverviewByCourseId(courseId));
    }

    @GetMapping("/{courseId}/detail")
    public ResponseEntity<List<LectureDetailDto>> getAllLectureDetailsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(this.lectureService.getAllLectureDetailByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<Void> createLecture(@RequestBody @Valid LectureCreateDto lectureCreateDto) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{lectureId}")
                .buildAndExpand(this.lectureService.createLecture(lectureCreateDto))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{lectureId}")
    public ResponseEntity<Void> updateLecture(@PathVariable Long lectureId, @RequestBody @Valid LectureUpdateDto lectureUpdateDto) {
        this.lectureService.updateLecture(lectureId, lectureUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{lectureId}")
    public ResponseEntity<Void> deleteLectureById(@PathVariable Long lectureId) {
        this.lectureService.deleteLecture(lectureId);
        return ResponseEntity.noContent().build();
    }

}
