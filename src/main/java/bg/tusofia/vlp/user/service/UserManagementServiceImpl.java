package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.exception.UserNotFoundException;
import bg.tusofia.vlp.notification.domain.NotificationType;
import bg.tusofia.vlp.notification.service.NotificationService;
import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.dto.*;
import bg.tusofia.vlp.user.mapper.UserMapper;
import bg.tusofia.vlp.user.repository.UserRepository;
import bg.tusofia.vlp.user.repository.UserSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;

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
    private final NotificationService notificationService;

    @Value("${user.profile.image.upload-dir}")
    private String uploadDir;

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
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public List<UserAnalyticsDto> getUserAnalytics() {
        long totalActiveUsers = userRepository.countAllByEnabled(true);
        long totalStudents = userRepository.countAllByRole(RoleType.ROLE_STUDENT);
        long totalTeachers = userRepository.countAllByRole(RoleType.ROLE_TEACHER);
        long totalAdmins = userRepository.countAllByRole(RoleType.ROLE_ADMIN);
        return List.of(
                new UserAnalyticsDto("Active Users", totalActiveUsers),
                new UserAnalyticsDto("Total Students", totalStudents),
                new UserAnalyticsDto("Total Teachers", totalTeachers),
                new UserAnalyticsDto("Total Admins", totalAdmins)
        );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public Page<UserTeacherAccessRequestDto> getUserTeacherAccessRequests(PageRequest pageRequest) {
        return userRepository.findAllUserTeacherAccessRequests(pageRequest);
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
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public void approveTeacherAccess(Long userId) {
        User user = checkUserExistsById(userId);
        user.setRole(RoleType.ROLE_TEACHER);
        user.setTeacherAccessRequested(false);
        userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public void denyTeacherAccess(Long userId) {
        User user = checkUserExistsById(userId);
        user.setTeacherAccessRequested(false);
        userRepository.save(user);
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
            notificationService.createNotification(userId,
                    NotificationType.ROLE_CHANGED,
                    MessageFormat.format("Your role has been changed to {0}", newRole)
            );
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
            notificationService.createNotification(userId,
                    NotificationType.ROLE_CHANGED,
                    "Your have been granted an Admin access!"
            );
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
            notificationService.createNotification(userId,
                    NotificationType.ROLE_CHANGED,
                    "Your have been granted a Teacher access!"
            );
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
    public void changeUserPassword(Long userId, UserPasswordUpdateDto userPasswordUpdateDto) {
        checkUserAuthorization(userId);
        User user = checkUserExistsById(userId);
        if (!passwordEncoder.matches(userPasswordUpdateDto.currentPassword(), user.getPassword())) {
            throw new AccessDeniedException("Passwords do not match");
        }
        user.setPassword(passwordEncoder.encode(userPasswordUpdateDto.newPassword()));
        user.setLastPasswordChangeDate(LocalDateTime.now());
        userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changeUserProfile(Long userId, UserProfileUpdateDto userProfileUpdateDto) {
        checkUserAuthorization(userId);
        User user = checkUserExistsById(userId);
        user.setFirstName(userProfileUpdateDto.firstName());
        user.setLastName(userProfileUpdateDto.lastName());
        user.setBio(userProfileUpdateDto.bio());
        user.setLinkedInProfileUrl(userProfileUpdateDto.linkedInProfileUrl());
        userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changeUserAvatar(long userId, MultipartFile avatar) {
        checkUserAuthorization(userId);
        User user = checkUserExistsById(userId);
        String imagePath = saveFile(avatar, userId);
        user.setProfileImagePath(imagePath);
        userRepository.save(user);
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
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    private String saveFile(MultipartFile file, Long userId) {
        try {
            Path baseDir = Paths.get(uploadDir);
            if (!Files.exists(baseDir)) {
                Files.createDirectories(baseDir);
            }
            Path userDir = baseDir.resolve(String.valueOf(userId));
            if (!Files.exists(userDir)) {
                Files.createDirectories(userDir);
            }
            String fileName = MessageFormat.format("user_{0}_{1}", userId, file.getOriginalFilename());
            Path filePath = userDir.resolve(fileName);
            Files.copy(file.getInputStream(), filePath);
            return filePath.toString();

        } catch (IOException e) {
            throw new RuntimeException("Failed to save file", e);
        }
    }

    private void checkUserAuthorization(Long userId) {
        if (!getCurrentAuthenticatedUser().getId().equals(userId)) {
            throw new AccessDeniedException("You do not have permission to access this resource");
        }
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
