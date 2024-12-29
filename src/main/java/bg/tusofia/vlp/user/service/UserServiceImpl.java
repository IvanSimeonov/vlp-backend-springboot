package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.course.domain.Status;
import bg.tusofia.vlp.exception.UserNotFoundException;
import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.dto.TeacherOverviewDto;
import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserPublicProfileDto;
import bg.tusofia.vlp.user.mapper.UserMapper;
import bg.tusofia.vlp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class: UserServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Long createUser(UserCreateDto userCreateDto) {
        User user = this.userRepository.save(this.userMapper.userCreateDtoToUser(userCreateDto));
        return user.getId();
    }

    @Override
    public List<UserOverviewDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::userToUserOverviewDto).toList();
    }

    @Override
    public UserOverviewDto getUserOverviewById(Long id) {
        return this.userMapper.userToUserOverviewDto(this.userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TeacherOverviewDto> getTopTeachersByStudentCount() {
        return userRepository.findTop3TeachersByEnrolledStudents().stream()
                .map(userMapper::teacherOverviewToTeacherOverviewDto)
                .toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserPublicProfileDto getUserPublicProfileById(Long userId) {
        var user = checkUserExistsById(userId);
        var userDto = userMapper.userToUserPublicProfileDto(user);
        var userPublishedCourses = userDto.createdCourses()
                .stream()
                .filter(courseOverviewDto -> courseOverviewDto.status() == Status.PUBLISHED)
                .toList();
        return new UserPublicProfileDto(
                userDto.id(),
                userDto.firstName(),
                userDto.lastName(),
                userDto.bio(),
                userDto.linkedInProfileUrl(),
                userDto.email(),
                userDto.profileImagePath(),
                userDto.role(),
                userDto.isTeacherAccessRequested(),
                userPublishedCourses,
                userDto.enrolledCourses(),
                userDto.completedCourses()
        );
    }

    @Override
    public void requestTeacherAccess() {
        var authUser = getCurrentAuthenticatedUser();
        var existingUser = checkUserExistsById(authUser.getId());
        if (existingUser.getRole() != RoleType.ROLE_STUDENT) {
            throw new AccessDeniedException("Access denied");
        }
        if (existingUser.isTeacherAccessRequested()) {
            throw new IllegalStateException("Teacher access has already been requested");
        }
        existingUser.setTeacherAccessRequested(true);
        userRepository.save(existingUser);
    }

    private User checkUserExistsById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    private User getCurrentAuthenticatedUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return (User) authentication.getPrincipal();
        }
        throw new IllegalArgumentException("Unauthorized access: No valid user context found");
    }
}
