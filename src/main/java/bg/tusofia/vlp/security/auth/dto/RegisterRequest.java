package bg.tusofia.vlp.security.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

/**
 * Record: RegisterRequest
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Builder
public record RegisterRequest(
    @NotBlank(message = "First Name is required")
    @Size(min = 2, max = 30, message = "First Name must be between 2 and 30 characters")
    String firstName,

    @NotBlank(message = "Last Name is required")
    @Size(min = 2, max = 30, message = "Last Name must be between 2 and 30 characters")
    String lastName,

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be in valid format")
    String email,

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 30, message = "Password must be between 8 and 30 characters")
    String password
){
}
