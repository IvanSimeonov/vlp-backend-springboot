package bg.tusofia.vlp.exception;

/**
 * Class: FileStorageException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class FileStorageException extends RuntimeException {

    public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
