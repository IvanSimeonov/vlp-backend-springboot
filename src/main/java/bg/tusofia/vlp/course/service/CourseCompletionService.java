package bg.tusofia.vlp.course.service;

/**
 * Interface: CourseCompletionService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface CourseCompletionService {
    void gradeSolution(Long assignmentSolutionId, Integer grade);
    void gradeAndCompleteCourse(Long assignmentSolutionId);
}
