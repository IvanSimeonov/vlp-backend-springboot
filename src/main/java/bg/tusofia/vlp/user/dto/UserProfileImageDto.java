package bg.tusofia.vlp.user.dto;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

/**
 * Record: UserProfileImageDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record UserProfileImageDto(@NotNull(message = "Profile image (avatar) is required") MultipartFile avatar) {
}
