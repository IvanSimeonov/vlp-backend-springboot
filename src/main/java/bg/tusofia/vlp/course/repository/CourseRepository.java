package bg.tusofia.vlp.course.repository;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.domain.CourseOverview;
import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.course.dto.CourseAnalyticsDto;
import bg.tusofia.vlp.topic.domain.Topic;
import bg.tusofia.vlp.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface: CourseRepository
 * <p>
 * A repository interface for managing the data access operations for the Course entity.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

    Optional<Course> findCourseById(Long id);

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

    @Query("SELECT c.id AS id, c.title AS title, c.difficultyLevel AS difficultyLevel, c.author AS author, " +
            "(SELECT COALESCE(AVG(cr.rating), 0) FROM CourseRating cr WHERE cr.course.id = c.id) AS averageRating, " +
            "(SELECT COUNT(cr) FROM CourseRating cr WHERE cr.course.id = c.id) AS totalRatings " +
            "FROM Course c WHERE c.id = :id"
    )
    CourseOverview findCourseOverviewById(Long id);
    Page<CourseOverview> findCourseOverviewByTopic(Topic topic, Pageable pageable);
    Page<CourseOverview> findAllProjectedBy(Pageable pageable);

    @Query("SELECT new bg.tusofia.vlp.course.dto.CourseAnalyticsDto(c.difficultyLevel, COUNT(c)) " +
    "FROM Course c GROUP BY c.difficultyLevel")
    List<CourseAnalyticsDto> findCourseAnalytics();
}
