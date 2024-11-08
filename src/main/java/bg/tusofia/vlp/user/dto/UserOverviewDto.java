package bg.tusofia.vlp.user.dto;

/**
 * Record: UserOverviewDto
 * <p>
 * A data transfer object (DTO) for displaying minimal user information, such as only basic author details.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record UserOverviewDto(Long id, String firstName, String lastName) {
}
