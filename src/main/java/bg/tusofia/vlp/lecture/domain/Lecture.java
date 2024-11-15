package bg.tusofia.vlp.lecture.domain;

import bg.tusofia.vlp.assignment.domain.AssignmentSolution;
import bg.tusofia.vlp.course.domain.Course;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
public class Lecture implements Serializable {

    @Serial
    private static final long serialVersionUID = 201038943719721117L;

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

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AssignmentSolution> assignmentSolutions = new HashSet<>();

    public void addAssignmentSolution(AssignmentSolution assignmentSolution) {
        assignmentSolutions.add(assignmentSolution);
        assignmentSolution.setLecture(this);
    }

    public void removeAssignmentSolution(AssignmentSolution assignmentSolution) {
        assignmentSolutions.remove(assignmentSolution);
        assignmentSolution.setLecture(null);
    }

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
