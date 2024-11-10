package bg.tusofia.vlp.user.repository;

import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.dto.UserSearchCriteriaDto;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: UserSpecifications
 * Provides specifications for querying User entities based on various criteria.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class UserSpecifications {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String ROLE_TYPE = "role";

    public static Specification<User> getUsersByCriteria(UserSearchCriteriaDto userSearchCriteriaDto) {
        return ((root, query, criteriaBuilder) -> {
            final List<Predicate> predicates = new ArrayList<>();
            addLikePredicateIfNotNullOrEmpty(predicates, criteriaBuilder, root.get(FIRST_NAME), userSearchCriteriaDto.firstName());
            addLikePredicateIfNotNullOrEmpty(predicates, criteriaBuilder, root.get(LAST_NAME), userSearchCriteriaDto.lastName());
            addLikePredicateIfNotNullOrEmpty(predicates, criteriaBuilder, root.get(EMAIL), userSearchCriteriaDto.email());
            addRoleTypePredicateIfNotNull(predicates, criteriaBuilder, root.get(ROLE_TYPE), userSearchCriteriaDto.roleType());
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

    private static void addLikePredicateIfNotNullOrEmpty(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Expression<String> path, String value) {
        if (!ObjectUtils.isEmpty(value)) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(path), "%" + value.toLowerCase() + "%"));
        }
    }

    private static void addRoleTypePredicateIfNotNull(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Expression<?> path, Enum<?> roleType) {
        if (roleType != null) {
            predicates.add(criteriaBuilder.equal(path, roleType));
        }
    }
}
