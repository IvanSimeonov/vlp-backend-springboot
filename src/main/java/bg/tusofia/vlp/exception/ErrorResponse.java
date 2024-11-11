package bg.tusofia.vlp.exception;

/**
 * Class: ErrorResponse
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record ErrorResponse(int errorCode, String errorMessage) {
}
