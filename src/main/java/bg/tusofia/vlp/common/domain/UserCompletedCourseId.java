package bg.tusofia.vlp.common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class: UserCompletedCourseId
 * <p>
 * A composite key representing the many-to-many relationship between the {@link bg.tusofia.vlp.course.domain.Course} and
 * {@link bg.tusofia.vlp.user.domain.User} tables. This key is formed by combining the primary keys of both tables,
 * which together serve as the primary key for the join table in this relationship.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class UserCompletedCourseId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "course_id")
    private Long courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCompletedCourseId that = (UserCompletedCourseId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, courseId);
    }
}
