package bg.tusofia.vlp.course.domain;

import bg.tusofia.vlp.common.domain.UserCompletedCourse;
import bg.tusofia.vlp.courserating.domain.CourseRating;
import bg.tusofia.vlp.lecture.domain.Lecture;
import bg.tusofia.vlp.topic.domain.Topic;
import bg.tusofia.vlp.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Class: Course
 * <p>
 * An entity representing a course on the platform
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Entity(name = "Course")
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = -1659139044663434546L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String shortDescription;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String fullDescription;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String requirements;

    @Column(nullable = false)
    private int passingScore;

    private String imagePath;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime modified;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CourseRating> ratings = new HashSet<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserCompletedCourse> completedUsers = new HashSet<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_enrolled_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> enrolledUsers = new HashSet<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Lecture> lectures = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Topic topic;

    public void addRating(CourseRating rating) {
        ratings.add(rating);
        rating.setCourse(this);
    }

    public void removeRating(CourseRating rating) {
        ratings.remove(rating);
        rating.setCourse(null);
    }

    public void addCompletedUser(User user) {
        UserCompletedCourse uc = new UserCompletedCourse(user, this);
        completedUsers.add(uc);
        user.getCompletedCourses().add(uc);
    }

    public void removeCompletedUser(User user) {
        for (Iterator<UserCompletedCourse> it = completedUsers.iterator(); it.hasNext(); ) {
            UserCompletedCourse uc = it.next();
            if (uc.getUser().equals(user) && uc.getCourse().equals(this)) {
                it.remove();
                uc.getUser().getCompletedCourses().remove(uc);
                uc.setCourse(null);
                uc.setUser(null);
            }
        }
    }

    public void addEnrolledUser(User user) {
        enrolledUsers.add(user);
        user.getEnrolledCourses().add(this);
    }

    public void removeEnrolledUser(User user) {
        enrolledUsers.remove(user);
        user.getEnrolledCourses().remove(this);
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
        lecture.setCourse(this);
    }

    public void removeLecture(Lecture lecture) {
        lectures.remove(lecture);
        lecture.setCourse(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        return id != null && id.equals(((Course) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
