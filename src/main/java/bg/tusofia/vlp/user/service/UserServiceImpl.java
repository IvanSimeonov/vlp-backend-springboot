package bg.tusofia.vlp.user.service;

import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.mapper.UserMapper;
import bg.tusofia.vlp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class: UserServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
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
        return this.userMapper.userOverviewToUserOverviewDto(this.userRepository.findUserOverviewById(id));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
