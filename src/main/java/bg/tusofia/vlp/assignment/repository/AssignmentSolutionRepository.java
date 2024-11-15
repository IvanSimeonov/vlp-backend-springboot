package bg.tusofia.vlp.assignment.repository;

import bg.tusofia.vlp.assignment.domain.AssignmentSolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface: AssignmentSolutionRepository
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Repository
public interface AssignmentSolutionRepository extends JpaRepository<AssignmentSolution, Long> {
}
