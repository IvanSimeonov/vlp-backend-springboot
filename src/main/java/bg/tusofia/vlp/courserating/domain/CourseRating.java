package bg.tusofia.vlp.courserating.domain;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Class: Rating
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Entity(name = "CourseRating")
@Table(name = "course_rating")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseRating implements Serializable {
    @Serial
    private static final long serialVersionUID = 7233435619434675535L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rating;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @CreationTimestamp
    private LocalDateTime created;

    public CourseRating(Course course, User user, Integer rating) {
        this.course = course;
        this.user = user;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseRating)) return false;
        return id != null && id.equals(((CourseRating) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
