package bg.tusofia.vlp.user.dto;

import bg.tusofia.vlp.course.dto.CourseOverviewDto;
import bg.tusofia.vlp.user.domain.RoleType;

import java.util.List;

/**
 * Record: UserPublicProfileDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record UserPublicProfileDto(
        Long id,
        String firstName,
        String lastName,
        String bio,
        String linkedInProfileUrl,
        String email,
        String profileImagePath,
        RoleType role,
        boolean isTeacherAccessRequested,
        List<CourseOverviewDto> createdCourses,
        List<CourseOverviewDto> enrolledCourses,
        List<CourseOverviewDto> completedCourses) {
}
