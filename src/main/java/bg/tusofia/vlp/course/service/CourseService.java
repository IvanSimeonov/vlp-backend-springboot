package bg.tusofia.vlp.course.service;

import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseOverviewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface: CourseService
 * <p>
 * Service interface for managing course-related operations. Provides methods that will be
 * implemented to interact with course data at the service level.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface CourseService {
    Long createCourse(CourseCreateDto courseCreateDto);

    CourseOverviewDto getCourseOverviewById(Long courseId);

    Page<CourseOverviewDto> getAllCourses(Pageable pageable);
}
