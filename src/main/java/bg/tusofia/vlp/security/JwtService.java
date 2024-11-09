package bg.tusofia.vlp.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Class: JwtService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtConfigurationProperties jwtConfigurationProperties;

    public String generateAccessToken(Map<String, Object> additionalClaims, UserDetails userDetails) {
        return generateToken(additionalClaims, userDetails, jwtConfigurationProperties.accessTokenExpiration());
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails, jwtConfigurationProperties.refreshTokenExpiration());
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        return extractClaim(token, Claims::getSubject).equals(userDetails.getUsername())
                && extractClaim(token, Claims::getExpiration).after(new Date());
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final var claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private String generateToken(Map<String, Object> additionalClaims, UserDetails userDetails, Long expiration) {
        return Jwts.builder()
                .claims(additionalClaims)
                .subject(userDetails.getUsername())
                .issuer(jwtConfigurationProperties.issuer())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSecretKey())
                .compact();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtConfigurationProperties.secret())
        );
    }
}
