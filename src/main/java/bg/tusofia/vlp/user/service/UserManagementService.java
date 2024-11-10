package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserSearchCriteriaDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface: UserManagementService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface UserManagementService {
    void assignAdminRole(Long userId);
    void assignTeacherRole(Long userId);
    void disableUser(Long userId);
    void enableUser(Long userId);
    void deleteUser(Long userId);
    Long createAdminUser(Long userId);
    Page<UserOverviewDto> getAllUsers(UserSearchCriteriaDto criteria, Pageable pageable);
}
