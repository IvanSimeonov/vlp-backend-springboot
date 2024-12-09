package bg.tusofia.vlp.assignment.repository;

import bg.tusofia.vlp.assignment.domain.AssignmentSolution;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface: AssignmentSolutionRepository
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Repository
@JaversSpringDataAuditable
public interface AssignmentSolutionRepository extends JpaRepository<AssignmentSolution, Long> {
    Optional<AssignmentSolution> findByLecture_IdAndStudent_Id(Long lectureId, Long userId);
    List<AssignmentSolution> findAllByLecture_Course_Id(Long courseId);
    List<AssignmentSolution> findAllByLecture_Course_IdAndStudent_Id(Long courseId, Long userId);
    List<AssignmentSolution> findByStudentId(Long studentId);
    List<AssignmentSolution> findByLectureId(Long lectureId);
}
