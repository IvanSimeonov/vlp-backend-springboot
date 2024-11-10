package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserSearchCriteriaDto;
import bg.tusofia.vlp.user.mapper.UserMapper;
import bg.tusofia.vlp.user.repository.UserRepository;
import bg.tusofia.vlp.user.repository.UserSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public void assignAdminRole(Long userId) {

    }

    @Override
    public void assignTeacherRole(Long userId) {

    }

    @Override
    public void disableUser(Long userId) {

    }

    @Override
    public void enableUser(Long userId) {

    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public Long createAdminUser(Long userId) {
        return 0L;
    }

    @Override
    public Page<UserOverviewDto> getAllUsers(UserSearchCriteriaDto criteria, Pageable pageable) {
        var users = userRepository.findAll(UserSpecifications.getUsersByCriteria(criteria), pageable);
        return users.map(userMapper::userToUserOverviewDto);
    }
}
