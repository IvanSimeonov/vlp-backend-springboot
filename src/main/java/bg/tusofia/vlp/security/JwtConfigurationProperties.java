package bg.tusofia.vlp.security;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Class: JwtConfigurationProperties
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@ConfigurationProperties(prefix = "jwt")
public record JwtConfigurationProperties(String secret, String issuer, Long accessTokenExpiration, Long refreshTokenExpiration) {
}
