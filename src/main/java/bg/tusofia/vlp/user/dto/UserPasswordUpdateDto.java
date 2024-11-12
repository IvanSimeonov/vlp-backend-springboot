package bg.tusofia.vlp.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Record: UserPasswordUpdateDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record UserPasswordUpdateDto(@NotBlank(message = "Current password is required")
                                    String currentPassword,
                                    @NotBlank(message = "New password is required") @Size(min = 8, max = 16, message = "New password must be between 8 and 16 characters long")
                                    String newPassword) {
}
