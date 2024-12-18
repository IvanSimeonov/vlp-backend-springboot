package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.user.dto.TeacherOverviewDto;
import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserPublicProfileDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Interface: UserService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface UserService extends UserDetailsService {
    Long createUser(UserCreateDto userCreateDto);

    List<UserOverviewDto> getAllUsers();

    UserOverviewDto getUserOverviewById(Long id);

    void requestTeacherAccess();

    /**
     * Provides the functionality to retrieve the public profile of a user by ID.
     * @param userId the ID of the user
     * @return the public profile of the user
     */
    UserPublicProfileDto getUserPublicProfileById(Long userId);

    /**
     * Retrieves the top 3 teachers with the most students enrolled in their courses.
     *
     * @return List of top 3 teachers sorted by total enrolled students in descending order
     */
    List<TeacherOverviewDto> getTopTeachersByStudentCount();
}
