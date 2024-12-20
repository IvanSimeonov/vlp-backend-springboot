package bg.tusofia.vlp.lecture.dto;

/**
 * Record: LectureDetailDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record LectureDetailDto(
        Long id,
        String title,
        String description,
        String videoUrl,
        String assignmentTask,
        int sequenceNumber,
        Long courseId
) {
}
