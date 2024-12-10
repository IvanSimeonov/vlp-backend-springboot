package bg.tusofia.vlp.topic.domain;

import bg.tusofia.vlp.course.domain.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javers.core.metamodel.annotation.ShallowReference;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Class: Topic
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Entity(name = "Topic")
@Table(name = "topic")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Topic implements Serializable {

    @Serial
    private static final long serialVersionUID = 5289108065803348476L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String title;

    private String description;

    @OneToMany(mappedBy = "topic", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, orphanRemoval = true)
    @ShallowReference
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course) {
        courses.add(course);
        course.setTopic(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.setTopic(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic)) return false;
        return id != null && id.equals(((Topic) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
