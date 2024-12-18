package bg.tusofia.vlp.user.domain;

/**
 * Interface: TeacherOverview
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface TeacherOverview {
    Long getId();
    String getFirstName();
    String getLastName();
    String getEmail();
    String getProfileImagePath();
}
