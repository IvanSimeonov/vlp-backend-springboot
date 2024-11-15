package bg.tusofia.vlp.exception;

import java.text.MessageFormat;

/**
 * Class: AssignmentSolutionNotFoundException
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class AssignmentSolutionNotFoundException extends RuntimeException {
    private static final String ASSIGNMENT_SOLUTION_NOT_FOUND = "Assignment solution with id {0} was not found";

    public AssignmentSolutionNotFoundException(Long id) {
        super(MessageFormat.format(ASSIGNMENT_SOLUTION_NOT_FOUND, id));
    }
}
