package bg.tusofia.vlp.security.auth.service;

import bg.tusofia.vlp.security.JwtService;
import bg.tusofia.vlp.security.auth.dto.AuthRequest;
import bg.tusofia.vlp.security.auth.dto.AuthResponse;
import bg.tusofia.vlp.security.auth.dto.RegisterRequest;
import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.mapper.UserMapper;
import bg.tusofia.vlp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Class: AuthServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    @Override
    public AuthResponse register(RegisterRequest registerRequest) {
       var user = User.builder()
               .firstName(registerRequest.firstName())
               .lastName(registerRequest.lastName())
               .password(passwordEncoder.encode(registerRequest.password()))
               .email(registerRequest.email())
               .role(RoleType.ROLE_STUDENT)
               .enabled(true)
               .build();
       var savedUser = userRepository.save(user);
       var accessToken = jwtService.generateAccessToken(null, savedUser);
       var refreshToken = jwtService.generateRefreshToken(savedUser);
       return new AuthResponse(accessToken, refreshToken, userMapper.userToUserOverviewDto(savedUser));
    }

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        var user = userRepository.findUserByEmail(authRequest.getEmail()).orElseThrow(() -> new UsernameNotFoundException(authRequest.getEmail()));
        var accessToken = jwtService.generateAccessToken(null, user);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .userOverviewDto(userMapper.userToUserOverviewDto(user))
                .build();
    }
}
