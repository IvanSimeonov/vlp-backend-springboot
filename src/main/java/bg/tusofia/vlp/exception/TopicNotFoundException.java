package bg.tusofia.vlp.exception;

import java.text.MessageFormat;

/**
 * Class: TopicNotFoundException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class TopicNotFoundException extends RuntimeException {
    private static final String TOPIC_NOT_FOUND = "Topic with id {0} was not found";

    public TopicNotFoundException(Long id) {
        super(MessageFormat.format(TOPIC_NOT_FOUND, id));
    }
}
