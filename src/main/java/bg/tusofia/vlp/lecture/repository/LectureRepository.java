package bg.tusofia.vlp.lecture.repository;

import bg.tusofia.vlp.lecture.domain.Lecture;
import bg.tusofia.vlp.lecture.domain.LectureDetail;
import bg.tusofia.vlp.lecture.domain.LectureOverview;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface: LectureRepository
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Repository
@JaversSpringDataAuditable
public interface LectureRepository extends JpaRepository<Lecture, Long> {
    List<Lecture> findAllByCourseId(Long courseId);
    Optional<Lecture> findLectureById(Long id);
    List<LectureOverview> findAllLectureOverviewByCourseIdOrderBySequenceNumber(Long courseId);
    List<LectureDetail> findAllLectureDetailsByCourseIdOrderBySequenceNumber(Long courseId);
    Optional<LectureDetail> findLectureDetailById(Long id);
    Optional<LectureDetail> findLectureDetailByCourseIdAndSequenceNumber(Long courseId, int sequenceNumber);
}
