package bg.tusofia.vlp.user.dto;

import bg.tusofia.vlp.user.domain.RoleType;
import jakarta.validation.constraints.NotNull;

/**
 * Record: UserAccessUpdateDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record UserAccessUpdateDto(@NotNull RoleType roleType, @NotNull Boolean enabled) {
}
