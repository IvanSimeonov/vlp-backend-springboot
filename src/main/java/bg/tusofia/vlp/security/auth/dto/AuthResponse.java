package bg.tusofia.vlp.security.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class: AuthResponse
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    @NotBlank(message = "Access Token is required")
    private String accessToken;

    @NotBlank(message = "Refresh Token is required")
    private String refreshToken;
}
