package bg.tusofia.vlp.lecture.domain;

/**
 * Interface: LectureOverview
 * <p>
 * Projection for the lecture overview, containing only a subset of the properties to limit exposed fields.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface LectureOverview {
    Long getId();
    String getTitle();
    String getShortDescription();
}
