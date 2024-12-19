package bg.tusofia.vlp.exception;

import java.text.MessageFormat;

/**
 * Class: CannotDeleteCourseException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class CannotDeleteCourseException extends RuntimeException {
    private static final String CANNOT_DELETE_COURSE = "Course with id {0} canot be deleted. Users are enrolled or have already completed it.";

    public CannotDeleteCourseException(Long id) {
        super(MessageFormat.format(CANNOT_DELETE_COURSE, id));
    }
}
