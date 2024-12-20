package bg.tusofia.vlp.lecture.service;

import bg.tusofia.vlp.lecture.dto.*;

import java.util.List;

/**
 * Interface: LectureService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface LectureService {

    LectureDetailDto getLectureDetailsById(Long lectureId);
    List<LectureOverviewDto> getAllLectureOverviewByCourseId(Long courseId);
    List<LectureDetailDto> getAllLectureDetailByCourseId(Long courseId);
    LectureDto createUpdateLecture(LectureDto lectureDto);
    List<LectureDto> createUpdateLectures(Long courseId, List<LectureDto> lectureDtos);
    void deleteLecture(Long lectureId);
}
