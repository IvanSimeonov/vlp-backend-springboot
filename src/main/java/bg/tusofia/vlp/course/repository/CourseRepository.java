package bg.tusofia.vlp.course.repository;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.domain.CourseOverview;
import bg.tusofia.vlp.course.dto.CourseAnalyticsDto;
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

    @Query("SELECT c.id AS id, c.title AS title, c.shortDescription AS shortDescription, " +
            "c.difficultyLevel AS difficultyLevel, c.author AS author, c.topic AS topic, c.imagePath AS imagePath, " +
            "(SELECT COALESCE(AVG(cr.rating), 0) FROM CourseRating cr WHERE cr.course.id = c.id) AS averageRating, " +
            "(SELECT COUNT(cr) FROM CourseRating cr WHERE cr.course.id = c.id) AS totalRatings " +
            "FROM Course c WHERE c.id = :id"
    )
    CourseOverview findCourseOverviewById(Long id);

    @Query("SELECT c.id AS id, " +
            "c.title AS title, " +
            "c.shortDescription AS shortDescription, " +
            "c.author AS author, " +
            "c.topic AS topic, " +
            "c.difficultyLevel AS difficultyLevel, " +
            "c.imagePath AS imagePath, " +
            "(SELECT COALESCE(AVG(cr.rating), 0) FROM CourseRating cr WHERE cr.course.id = c.id) AS averageRating, " +
            "(SELECT COUNT(cr) FROM CourseRating cr WHERE cr.course.id = c.id) AS totalRatings, " +
            "(SIZE(c.enrolledUsers) + SIZE(c.completedUsers)) AS totalStudents " +
            "FROM Course c " +
            "WHERE c.status = 'PUBLISHED' " +
            "ORDER BY totalStudents DESC " +
            "LIMIT 10")
    List<CourseOverview> findTop10CoursesByStudentCount();

    @Query("SELECT new bg.tusofia.vlp.course.dto.CourseAnalyticsDto(c.difficultyLevel, COUNT(c)) " +
            "FROM Course c GROUP BY c.difficultyLevel"
    )
    List<CourseAnalyticsDto> findCourseAnalytics();
}
