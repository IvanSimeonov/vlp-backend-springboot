package bg.tusofia.vlp.lecture.mapper;

import bg.tusofia.vlp.lecture.domain.Lecture;
import bg.tusofia.vlp.lecture.domain.LectureDetail;
import bg.tusofia.vlp.lecture.domain.LectureOverview;
import bg.tusofia.vlp.lecture.dto.LectureCreateDto;
import bg.tusofia.vlp.lecture.dto.LectureDetailDto;
import bg.tusofia.vlp.lecture.dto.LectureOverviewDto;
import bg.tusofia.vlp.lecture.dto.LectureUpdateDto;
import org.mapstruct.Mapper;

/**
 * Interface: LectureMapper
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Mapper
public interface LectureMapper {
    Lecture lectureCreateDtoToLecture(LectureCreateDto lectureCreateDto);
    Lecture lectureUpdateDtoToLecture(LectureUpdateDto lectureUpdateDto);
    LectureDetailDto lectureDetailToLectureDetailDto(LectureDetail lectureDetail);
    LectureOverviewDto lectureOverviewToLectureOverviewDto(LectureOverview lectureOverview);
}
