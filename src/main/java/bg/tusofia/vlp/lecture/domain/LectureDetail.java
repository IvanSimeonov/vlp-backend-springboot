package bg.tusofia.vlp.lecture.domain;

/**
 * Interface: LectureDetail
 * <p>
 * Projection for the lecture overview, containing only a subset of the properties to limit exposed fields.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface LectureDetail {
    Long getId();
    String getTitle();
    String getFullDescription();
    String getVideoUrl();
    int getSequenceNumber();
}
