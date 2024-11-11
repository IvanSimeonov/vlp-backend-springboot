package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserSearchCriteriaDto;
import bg.tusofia.vlp.user.mapper.UserMapper;
import bg.tusofia.vlp.user.repository.UserRepository;
import bg.tusofia.vlp.user.repository.UserSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class: UserManagementServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserManagementServiceImpl implements UserManagementService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    /**
     * {@inheritDoc}
     */
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public UserOverviewDto getUserById(Long userId) {
        var user = checkUserExistsById(userId);
        return userMapper.userToUserOverviewDto(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public Page<UserOverviewDto> getAllUsers(UserSearchCriteriaDto criteria, Pageable pageable) {
        var users = userRepository.findAll(UserSpecifications.getUsersByCriteria(criteria), pageable);
        return users.map(userMapper::userToUserOverviewDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PreAuthorize("hasRole('ROLE_ROOT_ADMIN')")
    public Long createAdminUser(UserCreateDto userCreateDto) {
        var user = userMapper.userCreateDtoToUser(userCreateDto);
        user.setRole(RoleType.ROLE_ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user).getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public void changeUserRole(Long userId, RoleType newRole) {
        User user = checkUserExistsById(userId);
        checkSelfModification(userId);
        if (canModifyUserRole(user, newRole)) {
            user.setRole(newRole);
            userRepository.save(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public void assignAdminRole(Long userId) {
        User user = checkUserExistsById(userId);
        checkSelfModification(userId);
        if (canModifyUser(user)) {
            user.setRole(RoleType.ROLE_ADMIN);
            userRepository.save(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public void assignTeacherRole(Long userId) {
        User user = checkUserExistsById(userId);
        checkSelfModification(userId);
        if (canModifyUser(user)) {
            user.setRole(RoleType.ROLE_TEACHER);
            userRepository.save(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public void enableUser(Long userId) {
        var user = checkUserExistsById(userId);
        checkSelfModification(userId);
        if (canModifyUser(user)) {
            user.setEnabled(true);
            userRepository.save(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public void disableUser(Long userId) {
        var user = checkUserExistsById(userId);
        checkSelfModification(userId);
        if (canModifyUser(user)) {
            user.setEnabled(false);
            userRepository.save(user);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @PreAuthorize("hasRole('ROLE_ROOT_ADMIN')")
    public void deleteUser(Long userId) {
        User user = checkUserExistsById(userId);
        checkSelfModification(userId);
        userRepository.delete(user);
    }

    private User checkUserExistsById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    private void checkSelfModification(Long userId) {
        User currentUser = getCurrentAuthenticatedUser();
        if (currentUser.getId().equals(userId)) {
            throw new IllegalArgumentException("Cannot modify your own profile.");
        }
    }

    private boolean isUserToEditAdminOrRootAdmin(User user) {
        return user.getRole().equals(RoleType.ROLE_ADMIN) || user.getRole().equals(RoleType.ROLE_ROOT_ADMIN);
    }

    private boolean isCurrentUserRootAdmin() {
        return getCurrentAuthenticatedUser().getRole().equals(RoleType.ROLE_ROOT_ADMIN);
    }

    private boolean canModifyUserRole(User user, RoleType newRole) {
        return isCurrentUserRootAdmin() || (!isUserToEditAdminOrRootAdmin(user) && newRole != RoleType.ROLE_ROOT_ADMIN);
    }

    private boolean canModifyUser(User user) {
        return isCurrentUserRootAdmin() || !isUserToEditAdminOrRootAdmin(user);
    }

    private User getCurrentAuthenticatedUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return (User) authentication.getPrincipal();
        }
        throw new IllegalArgumentException("Unauthorized access: No valid user context found");
    }
}
