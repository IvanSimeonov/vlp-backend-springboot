package bg.tusofia.vlp.courserating.repository;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.courserating.domain.CourseRating;
import bg.tusofia.vlp.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface: CourseRatingRepository
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRating, Integer> {
    Optional<CourseRating> findByCourseAndUser(Course course, User user);
    boolean existsByCourseAndUser(Course course, User user);
}
