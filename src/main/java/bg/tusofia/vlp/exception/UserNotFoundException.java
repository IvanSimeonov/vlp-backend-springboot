package bg.tusofia.vlp.exception;

import java.text.MessageFormat;

/**
 * Class: UserNotFoundException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class UserNotFoundException extends RuntimeException {
    private static final String USER_NOT_FOUND = "User with id {0} was not found";

    public UserNotFoundException(Long id) {
        super(MessageFormat.format(USER_NOT_FOUND, id));
    }
}
