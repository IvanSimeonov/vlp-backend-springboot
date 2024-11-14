package bg.tusofia.vlp.lecture.domain;

import bg.tusofia.vlp.course.domain.Course;
import jakarta.persistence.*;
import lombok.*;

/**
 * Class: Lecture
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Entity(name = "Lecture")
@Table(name = "lecture")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String shortDescription;
    private String fullDescription;
    private String videoUrl;
    private int sequenceNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lecture)) return false;
        return id != null && id.equals(((Lecture) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
