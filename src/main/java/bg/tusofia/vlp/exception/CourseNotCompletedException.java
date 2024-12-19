package bg.tusofia.vlp.exception;

import java.text.MessageFormat;

/**
 * Class: CourseNotCompletedException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class CourseNotCompletedException extends RuntimeException {
    private static final String COURSE_NOT_COMPLETED = "Course with id {0} was not completed. Only completed courses can be rated!";

    public CourseNotCompletedException(Long id) {
        super(MessageFormat.format(COURSE_NOT_COMPLETED, id));
    }
}
