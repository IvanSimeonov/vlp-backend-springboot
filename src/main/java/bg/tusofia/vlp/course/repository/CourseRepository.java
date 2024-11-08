package bg.tusofia.vlp.course.repository;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.domain.CourseOverview;
import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface: CourseRepository
 * <p>
 * A repository interface for managing the data access operations for the Course entity.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * Retrieves a page of courses based on the specified title.
     *
     * @param title The title of the courses to retrieve.
     * @param pageable        The pagination information.
     * @return A page of courses matching the title.
     */
    Page<Course> findByTitleLike(String title, Pageable pageable);

    /**
     * Retrieves a page of courses based on the specified author.
     *
     * @param author   The author of the course.
     * @param pageable The pagination information.
     * @return A page of courses matching the author.
     */
    Page<Course> findByAuthor(User author, Pageable pageable);

    /**
     * Retrieves a page of courses based on the specified difficulty level.
     *
     * @param difficultyLevel The difficulty level of the courses to retrieve.
     * @param pageable        The pagination information.
     * @return A page of courses matching the difficulty level.
     */
    Page<Course> findByDifficultyLevel(DifficultyLevel difficultyLevel, Pageable pageable);

    CourseOverview findCourseOverviewById(Long id);
}
