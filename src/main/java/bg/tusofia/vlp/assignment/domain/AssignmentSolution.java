package bg.tusofia.vlp.assignment.domain;

import bg.tusofia.vlp.lecture.domain.Lecture;
import bg.tusofia.vlp.user.domain.User;
import jakarta.persistence.*;
import lombok.*;
import org.javers.core.metamodel.annotation.DiffIgnore;
import org.javers.core.metamodel.annotation.ShallowReference;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class: AssignmentSolution
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Entity(name = "AssignmentSolution")
@Table(name = "assignment_solution")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AssignmentSolution implements Serializable {

    @Serial
    private static final long serialVersionUID = 7745001033268763687L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String submissionFilePath;

    @Enumerated(EnumType.STRING)

    private SubmissionStatus submissionStatus;

    private boolean retryFlag;

    private Integer grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @ShallowReference
    private User student;

    @ManyToOne(fetch = FetchType.LAZY)
    @ShallowReference
    private Lecture lecture;
}
