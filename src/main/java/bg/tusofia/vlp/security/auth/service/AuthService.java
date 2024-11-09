package bg.tusofia.vlp.security.auth.service;

import bg.tusofia.vlp.security.auth.dto.AuthRequest;
import bg.tusofia.vlp.security.auth.dto.AuthResponse;
import bg.tusofia.vlp.security.auth.dto.RegisterRequest;

/**
 * Interface: AuthService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse authenticate(AuthRequest authRequest);
}
