package bg.tusofia.vlp.user.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * Record: UserProfileUpdateDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record UserProfileUpdateDto(@NotBlank String firstName, @NotBlank String lastName, String bio, String linkedInProfileUrl) {
}
