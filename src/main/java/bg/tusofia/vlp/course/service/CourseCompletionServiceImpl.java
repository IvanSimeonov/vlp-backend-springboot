package bg.tusofia.vlp.course.service;

import bg.tusofia.vlp.assignment.domain.AssignmentSolution;
import bg.tusofia.vlp.assignment.domain.SubmissionStatus;
import bg.tusofia.vlp.assignment.repository.AssignmentSolutionRepository;
import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.repository.CourseRepository;
import bg.tusofia.vlp.exception.AssignmentSolutionNotFoundException;
import bg.tusofia.vlp.lecture.domain.Lecture;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Class: CourseCompletionServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CourseCompletionServiceImpl implements CourseCompletionService {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final AssignmentSolutionRepository assignmentSolutionRepository;

    @Transactional
    public void gradeSolution(Long assignmentSolutionId, Integer grade) {
        var assignmentSolution = assignmentSolutionRepository.findById(assignmentSolutionId)
                .orElseThrow(() -> new AssignmentSolutionNotFoundException(assignmentSolutionId));
        assignmentSolution.setGrade(grade);
        assignmentSolution.setSubmissionStatus(SubmissionStatus.GRADED);
        assignmentSolutionRepository.saveAndFlush(assignmentSolution);
    }

    @Transactional
    @Override
    public void gradeAndCompleteCourse(Long assignmentSolutionId) {
        var assignmentSolution = assignmentSolutionRepository.findById(assignmentSolutionId)
                .orElseThrow(() -> new AssignmentSolutionNotFoundException(assignmentSolutionId));
//        var courseId = assignmentSolution.getLecture().getCourse().getId();
//        var studentId = assignmentSolution.getStudent().getId();
//        var course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(courseId));
//        var student = userRepository.findById(studentId).orElseThrow(() -> new UserNotFoundException(studentId));
        var course = assignmentSolution.getLecture().getCourse();
        var student = assignmentSolution.getStudent();

        if (areAllSolutionsGraded(course, student)) {
            // this.courseRepository.save(calculateAvgGradeAndCompleteCourse(course, student));
            calculateAvgGradeAndCompleteCourse(course, student);
        }

    }

    private Course calculateAvgGradeAndCompleteCourse(Course course, User student) {
        var totalGrade = course.getLectures().stream()
                .flatMap(lecture -> lecture.getAssignmentSolutions().stream())
                .filter(solution -> solution.getStudent().getId().equals(student.getId()))
                .map(AssignmentSolution::getGrade)
                .filter(Objects::nonNull)
                .map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        var totalGradedSolutions = course.getLectures().stream()
                .flatMap(lecture -> lecture.getAssignmentSolutions().stream())
                .filter(solution -> solution.getStudent().getId().equals(student.getId()))
                .count();

        var avgGrade = totalGrade.divide(BigDecimal.valueOf(totalGradedSolutions), 2, RoundingMode.HALF_UP);

        if (avgGrade.compareTo(BigDecimal.valueOf(course.getPassingScore())) >= 0) {
            course.removeEnrolledUser(student);
            course.addCompletedUser(student);
        }
        return course;
    }

    private boolean areAllSolutionsGraded(Course course, User student) {
        boolean areAllSolutionsGraded = true;
        for (Lecture lecture : course.getLectures()) {
            boolean hasGradedSolution = false;
            for (AssignmentSolution assignmentSolution : lecture.getAssignmentSolutions()) {
                if (Objects.equals(assignmentSolution.getStudent().getId(), student.getId()) && assignmentSolution.getGrade() != null) {
                    hasGradedSolution = true;
                    break;
                }
            }
            if (!hasGradedSolution) {
                areAllSolutionsGraded = false;
                break;
            }
        }
        return areAllSolutionsGraded;
    }

}
