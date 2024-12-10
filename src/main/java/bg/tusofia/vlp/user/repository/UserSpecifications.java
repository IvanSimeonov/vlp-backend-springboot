package bg.tusofia.vlp.user.repository;

import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.dto.UserSearchCriteriaDto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: UserSpecifications
 * Provides dynamic query specifications for the User entity based on search criteria.
 * <p>
 * This utility class constructs {@link Specification} instances, allowing flexible and efficient querying
 * of User entities, including filtering by firstName, lastName, email, role, and status.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public class UserSpecifications {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String ROLE_TYPE = "role";
    private static final String ENABLED = "enabled";

    /**
     * Constructs a {@link Specification} for querying {@link User} entities based on the provided search criteria.
     *
     * @param userSearchCriteriaDto the DTO containing search criteria
     * @return a {@link Specification} for filtering User entities
     */
    public static Specification<User> getUsersByCriteria(UserSearchCriteriaDto userSearchCriteriaDto) {
        return ((root, query, criteriaBuilder) -> {
            final List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(userSearchCriteriaDto.searchTerm())) {
                String formattedSearchTerm = "%" + userSearchCriteriaDto.searchTerm().toLowerCase() + "%";
                predicates.add(criteriaBuilder.or(
                        criteriaBuilder.like(criteriaBuilder.lower(root.get(FIRST_NAME)), formattedSearchTerm),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get(LAST_NAME)), formattedSearchTerm),
                        criteriaBuilder.like(criteriaBuilder.lower(root.get(EMAIL)), formattedSearchTerm)
                ));
            }

            if (userSearchCriteriaDto.roleType() != null) {
                predicates.add(criteriaBuilder.equal(root.get(ROLE_TYPE), userSearchCriteriaDto.roleType()));
            }
            if (userSearchCriteriaDto.enabled() != null) {
                predicates.add(criteriaBuilder.equal(root.get(ENABLED), userSearchCriteriaDto.enabled()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
