package bg.tusofia.vlp.user.dto;

import bg.tusofia.vlp.user.domain.RoleType;

import java.util.List;

/**
 * Record: UserOverviewDto
 * <p>
 * A data transfer object (DTO) for displaying minimal user information, such as only basic author details.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record UserOverviewDto(
        Long id,
        String firstName,
        String lastName,
        String email,
        RoleType role,
        boolean enabled,
        String created,
        String profileImagePath,
        List<Long> enrolledCoursesIds,
        List<Long> completedCoursesIds,
        List<Long> createdCoursesIds) {
}
