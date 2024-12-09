package bg.tusofia.vlp.course.repository;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.dto.CourseSearchCriteriaDto;
import bg.tusofia.vlp.topic.domain.Topic;
import bg.tusofia.vlp.user.domain.User;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: CourseSpecification
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class CourseSpecification {

    private static final String TITLE = "title";
    private static final String AUTHOR_NAME = "author";
    private static final String DIFFICULTY_LEVEL = "difficultyLevel";
    private static final String STATUS = "status";
    private static final String TOPIC = "topic";

    public static Specification<Course> getCoursesByCriteria(CourseSearchCriteriaDto criteria) {
        return ((root, query, criteriaBuilder) -> {
            final List<Predicate> predicates = new ArrayList<>();
            if (!ObjectUtils.isEmpty(criteria.title())) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(TITLE)), "%" + criteria.title().toLowerCase() + "%"));
            }
            if (!ObjectUtils.isEmpty(criteria.authorName())) {
                Join<Course, User> author = root.join(AUTHOR_NAME);
                Expression<String> authorFullName = criteriaBuilder.concat(
                        criteriaBuilder.concat(criteriaBuilder.lower(author.get("firstName")), " "),
                        criteriaBuilder.lower(author.get("lastName"))
                );
                predicates.add(criteriaBuilder.like(authorFullName, "%" + criteria.authorName() + "%"));
            }
            if (criteria.difficultyLevel() != null) {
                predicates.add(criteriaBuilder.equal(root.get(DIFFICULTY_LEVEL), criteria.difficultyLevel()));
            }
            if (criteria.status() != null) {
                predicates.add(criteriaBuilder.equal(root.get(STATUS), criteria.status()));
            }
            if (!ObjectUtils.isEmpty(criteria.topic())) {
                Join<Course, Topic> topic = root.join(TOPIC);
                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(topic.get("title")), "%" + criteria.topic() + "%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
