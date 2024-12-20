package bg.tusofia.vlp.lecture.controller;

import bg.tusofia.vlp.lecture.dto.LectureDetailDto;
import bg.tusofia.vlp.lecture.dto.LectureDto;
import bg.tusofia.vlp.lecture.dto.LectureOverviewDto;
import bg.tusofia.vlp.lecture.service.LectureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<LectureDetailDto> getLectureDetailsById(@PathVariable Long lectureId) {
        return ResponseEntity.ok(lectureService.getLectureDetailsById(lectureId));
    }

    @GetMapping("/{courseId}/overview")
    public ResponseEntity<List<LectureOverviewDto>> getAllLectureOverviewByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(lectureService.getAllLectureOverviewByCourseId(courseId));
    }

    @GetMapping("/{courseId}/detail")
    public ResponseEntity<List<LectureDetailDto>> getAllLectureDetailsByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(lectureService.getAllLectureDetailByCourseId(courseId));
    }

    @PostMapping
    public ResponseEntity<LectureDto> createUpdateLecture(@RequestBody @Valid LectureDto lectureDto) {
        return ResponseEntity.ok(lectureService.createUpdateLecture(lectureDto));
    }

    @PutMapping("/{courseId}/batch")
    public ResponseEntity<List<LectureDto>> updateLectures(@PathVariable Long courseId, @RequestBody @Valid List<LectureDto> lectureDtos) {
        return ResponseEntity.ok(lectureService.createUpdateLectures(courseId, lectureDtos));
    }

    @DeleteMapping("/{lectureId}")
    public ResponseEntity<Void> deleteLectureById(@PathVariable Long lectureId) {
        lectureService.deleteLecture(lectureId);
        return ResponseEntity.noContent().build();
    }

}
