package bg.tusofia.vlp.user.dto;

/**
 * Record: UserCreateDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record UserCreateDto(String firstName, String lastName, String email, String password) {
}
