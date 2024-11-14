package bg.tusofia.vlp.exception;

import java.text.MessageFormat;

/**
 * Class: LectureNotFoundException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class LectureNotFoundException extends RuntimeException {
    private static final String LECTURE_NOT_FOUND = "Lecture with id {0} was not found";

    public LectureNotFoundException(Long id) {
        super(MessageFormat.format(LECTURE_NOT_FOUND, id));
    }
}
