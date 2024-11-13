package bg.tusofia.vlp.exception;

import java.text.MessageFormat;

/**
 * Class: NotificationNotFoundException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class NotificationNotFoundException extends RuntimeException {
    private static final String NOTIFICATION_NOT_FOUND = "Notification with id {0} was not found";

    public NotificationNotFoundException(Long id) {
        super(MessageFormat.format(NOTIFICATION_NOT_FOUND, id));
    }
}
