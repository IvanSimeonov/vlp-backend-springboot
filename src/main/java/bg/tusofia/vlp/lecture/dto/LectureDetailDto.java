package bg.tusofia.vlp.lecture.dto;

/**
 * Record: LectureDetailDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record LectureDetailDto(Long id, String title, String fullDescription, String videoUrl, int sequenceNumber) {
}
