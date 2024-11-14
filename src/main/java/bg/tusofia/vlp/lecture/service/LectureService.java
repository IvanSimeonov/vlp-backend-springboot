package bg.tusofia.vlp.lecture.service;

import bg.tusofia.vlp.lecture.dto.LectureCreateDto;
import bg.tusofia.vlp.lecture.dto.LectureDetailDto;
import bg.tusofia.vlp.lecture.dto.LectureOverviewDto;
import bg.tusofia.vlp.lecture.dto.LectureUpdateDto;

import java.util.List;

/**
 * Interface: LectureService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface LectureService {
    LectureDetailDto getLectureDetailById(Long lectureId);
    List<LectureOverviewDto> getAllLectureOverviewByCourseId(Long courseId);
    List<LectureDetailDto> getAllLectureDetailByCourseId(Long courseId);
    Long createLecture(LectureCreateDto lectureCreateDto);
    void updateLecture(Long lectureId, LectureUpdateDto lectureUpdateDto);
    void deleteLecture(Long lectureId);
}
