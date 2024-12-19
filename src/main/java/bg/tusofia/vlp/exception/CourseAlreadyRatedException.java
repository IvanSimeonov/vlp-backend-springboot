package bg.tusofia.vlp.exception;

import java.text.MessageFormat;

/**
 * Class: CourseAlreadyRatedException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class CourseAlreadyRatedException extends RuntimeException {
    private static final String COURSE_ALREADY_RATED = "Course with id {0} was already rated by you!";

    public CourseAlreadyRatedException(Long id) {
        super(MessageFormat.format(COURSE_ALREADY_RATED, id));
    }
}
