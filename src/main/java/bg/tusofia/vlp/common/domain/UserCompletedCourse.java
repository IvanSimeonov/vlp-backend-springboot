package bg.tusofia.vlp.common.domain;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

/**
 * Class: UserCompletedCourse
 * <p>
 * A class representing the resulted join table created by the many-to-many association with extra column between the
 * {@link bg.tusofia.vlp.course.domain.Course} and {@link bg.tusofia.vlp.user.domain.User} tables.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Entity(name = "UserCompletedCourse")
@Table(name = "user_completed_course")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class UserCompletedCourse {

    @EmbeddedId
    private UserCompletedCourseId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
    private Course course;

    @Column(name = "completed_on")
    private Date completedOn = new Date();

    public UserCompletedCourse(User user, Course course) {
        this.user = user;
        this.course = course;
        this.id = new UserCompletedCourseId(user.getId(), course.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCompletedCourse that = (UserCompletedCourse) o;
        return Objects.equals(user, that.user) && Objects.equals(course, that.course) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, course);
    }

}
