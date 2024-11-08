package bg.tusofia.vlp.user.domain;

/**
 * Interface: UserOverview
 * <p>
 * Projection for a subset of user information, used to display minimal author details.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface UserOverview {
    Long getId();
    String getFirstName();
    String getLastName();
}
