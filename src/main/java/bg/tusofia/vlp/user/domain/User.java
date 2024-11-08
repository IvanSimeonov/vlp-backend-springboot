package bg.tusofia.vlp.user.domain;

import bg.tusofia.vlp.common.domain.UserCompletedCourse;
import bg.tusofia.vlp.course.domain.Course;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Class: User
 * <p>
 * An entity representing a user on the platform
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Entity(name = "User")
@Table(name = "user")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime modified;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> createdCourses = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserCompletedCourse> completedCourses = new HashSet<>();

    @ManyToMany(mappedBy = "enrolledUsers")
    private Set<Course> enrolledCourses = new HashSet<>();

    public void createCourse(Course course) {
        createdCourses.add(course);
        course.setAuthor(this);
    }

    public void deleteCourse(Course course) {
        createdCourses.remove(course);
        course.setAuthor(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
