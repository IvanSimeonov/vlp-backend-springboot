package bg.tusofia.vlp.user.dto;

import bg.tusofia.vlp.user.domain.RoleType;

/**
 * Record: UserSearchCriteriaDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record UserSearchCriteriaDto(String firstName, String lastName, String email, RoleType roleType, Boolean enabled) {
}
