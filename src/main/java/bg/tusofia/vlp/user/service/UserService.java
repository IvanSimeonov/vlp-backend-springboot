package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
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
}
