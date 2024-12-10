package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.exception.UserNotFoundException;
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
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
import java.util.Optional;

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
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public UserOverviewDto getUserById(Long userId) {
        var user = checkUserExistsById(userId);
        return userMapper.userToUserOverviewDto(user);
    }


    /**
     * {@inheritDoc}
     */
    @Override
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public Page<UserOverviewDto> getAllUsers(UserSearchCriteriaDto criteria, PageRequest pageRequest) {
        var users = userRepository.findAll(UserSpecifications.getUsersByCriteria(criteria), pageRequest);
        return users.map(userMapper::userToUserOverviewDto);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public List<UserAnalyticsDto> getUserAnalytics() {
        long totalActiveUsers = userRepository.countAllByEnabled(true);
        long totalStudents = userRepository.countAllByRoleAndEnabled(RoleType.ROLE_STUDENT, true);
        long totalTeachers = userRepository.countAllByRoleAndEnabled(RoleType.ROLE_TEACHER, true);
        long totalAdmins = userRepository.countAllByRoleAndEnabled(RoleType.ROLE_ADMIN, true);
        long totalRootAdmins = userRepository.countAllByRoleAndEnabled(RoleType.ROLE_ROOT_ADMIN, true);
        return List.of(
                new UserAnalyticsDto("Active Users", totalActiveUsers),
                new UserAnalyticsDto("Total Students", totalStudents),
                new UserAnalyticsDto("Total Teachers", totalTeachers),
                new UserAnalyticsDto("Total Admins", totalAdmins + totalRootAdmins)
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
//    @PreAuthorize("hasRole('ROLE_ROOT_ADMIN')")
    public Long createAdminUser(UserCreateDto userCreateDto) {
        var user = userMapper.userCreateDtoToUser(userCreateDto);
        user.setRole(RoleType.ROLE_ADMIN);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
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

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ROOT_ADMIN')")
    public void updateUserAccess(Long userId, UserAccessUpdateDto userAccessUpdateDto) {
        var user = checkUserExistsById(userId);
        checkSelfModification(userId);
        var currentUser = getCurrentAuthenticatedUser();
        var updated = false;
        if (canModifyUserRole(user, currentUser, userAccessUpdateDto.roleType())) {
            user.setRole(userAccessUpdateDto.roleType());
//            notificationService.createNotification(userId,
//                    NotificationType.ROLE_CHANGED,
//                    MessageFormat.format("Your role has been changed to {0}", userAccessUpdateDto.roleType())
//            );
            updated = true;
        }
        if (canModifyUser(user, currentUser)) {
            user.setEnabled(userAccessUpdateDto.enabled());
            updated = true;
        }
        if (updated) {
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
        var user = checkUserExistsById(userId);
        var imagePath = saveFile(avatar, userId);
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
        var currentUser = getCurrentAuthenticatedUser();
        if (currentUser.getId().equals(userId)) {
            throw new IllegalArgumentException("Cannot modify your own profile.");
        }
    }

    private User getCurrentAuthenticatedUser() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .filter(Authentication::isAuthenticated)
                .map(auth -> (User) auth.getPrincipal())
                .orElseThrow(() -> new IllegalArgumentException("Unauthorized access: No valid user context found"));
    }

    private boolean canModifyUserRole(User user, User currentUser, RoleType newRole) {
        return isUserRootAdmin(currentUser) || (!isUserAdminOrRootAdmin(user) && newRole != RoleType.ROLE_ROOT_ADMIN);
    }

    private boolean canModifyUser(User user, User currentUser) {
        return isUserRootAdmin(currentUser) || !isUserAdminOrRootAdmin(user);
    }

    private boolean isUserAdminOrRootAdmin(User user) {
        return isUserAdmin(user) || isUserRootAdmin(user);
    }

    private boolean isUserAdmin(User user) {
        return user.getRole() == (RoleType.ROLE_ADMIN);
    }

    private boolean isUserRootAdmin(User user) {
        return user.getRole() == (RoleType.ROLE_ROOT_ADMIN);
    }
}
