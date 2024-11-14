package bg.tusofia.vlp.lecture.service;

import bg.tusofia.vlp.exception.LectureNotFoundException;
import bg.tusofia.vlp.lecture.dto.LectureCreateDto;
import bg.tusofia.vlp.lecture.dto.LectureDetailDto;
import bg.tusofia.vlp.lecture.dto.LectureOverviewDto;
import bg.tusofia.vlp.lecture.dto.LectureUpdateDto;
import bg.tusofia.vlp.lecture.mapper.LectureMapper;
import bg.tusofia.vlp.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class: LectureServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@Transactional
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final LectureMapper lectureMapper;

    @Override
    public LectureDetailDto getLectureDetailById(Long lectureId) {
        return this.lectureMapper.lectureDetailToLectureDetailDto(
                this.lectureRepository.findLectureDetailById(lectureId)
                        .orElseThrow(() -> new LectureNotFoundException(lectureId))
        );
    }

    @Override
    public List<LectureOverviewDto> getAllLectureOverviewByCourseId(Long courseId) {
        return this.lectureRepository.findAllLectureOverviewByCourseIdOrderBySequenceNumber(courseId)
                .stream()
                .map(lectureMapper::lectureOverviewToLectureOverviewDto)
                .toList();
    }

    @Override
    public List<LectureDetailDto> getAllLectureDetailByCourseId(Long courseId) {
        return this.lectureRepository.findAllLectureDetailsByCourseIdOrderBySequenceNumber(courseId)
                .stream()
                .map(lectureMapper::lectureDetailToLectureDetailDto)
                .toList();
    }

    @Override
    public Long createLecture(LectureCreateDto lectureCreateDto) {
        var savedLecture = this.lectureRepository.save(lectureMapper.lectureCreateDtoToLecture(lectureCreateDto));
        return savedLecture.getId();
    }

    @Override
    public void updateLecture(Long lectureId, LectureUpdateDto lectureUpdateDto) {
        var lecture = this.lectureRepository.findById(lectureId).orElseThrow(() -> new LectureNotFoundException(lectureId));
        lecture.setTitle(lectureUpdateDto.title());
        lecture.setShortDescription(lectureUpdateDto.shortDescription());
        lecture.setFullDescription(lectureUpdateDto.fullDescription());
        lecture.setVideoUrl(lectureUpdateDto.videoUrl());
        lecture.setSequenceNumber(lectureUpdateDto.sequenceNumber());
        this.lectureRepository.save(lecture);
    }

    @Override
    public void deleteLecture(Long lectureId) {
        var lecture = this.lectureRepository.findById(lectureId).orElseThrow(() -> new LectureNotFoundException(lectureId));
        this.lectureRepository.delete(lecture);
    }
}
