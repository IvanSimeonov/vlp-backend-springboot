package bg.tusofia.vlp.exception;

import java.text.MessageFormat;

/**
 * Class: CourseNotFoundException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class CourseNotFoundException extends RuntimeException {
    private static final String COURSE_NOT_FOUND = "Course with id {0} was not found";

    public CourseNotFoundException(Long id) {
        super(MessageFormat.format(COURSE_NOT_FOUND, id));
    }
}
