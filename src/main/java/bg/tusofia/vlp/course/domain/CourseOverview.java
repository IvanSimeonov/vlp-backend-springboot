package bg.tusofia.vlp.course.domain;

import bg.tusofia.vlp.topic.domain.Topic;
import bg.tusofia.vlp.user.domain.User;

/**
 * Interface: CourseOverview
 * <p>
 * Projection for the course overview, containing only a subset of the properties
 * and a nested projection for the author to limit exposed fields.
 *
 * @since 0.0.1
 */
public interface CourseOverview {
    Long getId();
    String getTitle();
    String getShortDescription();
    User getAuthor();
    Double getAverageRating();
    Integer getTotalRatings();
    Topic getTopic();
    DifficultyLevel getDifficultyLevel();
    String getImagePath();
    Status getStatus();
}
