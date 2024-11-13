package bg.tusofia.vlp.user.repository;

import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.domain.UserOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * Interface: UserRepository
 * <p>
 * A repository interface for managing the data access operations for the Course entity.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    UserOverview findUserOverviewById(Long id);
    Optional<User> findUserByEmail(String email);
    List<UserOverview> findAllByRoleIn(List<RoleType> roleTypes);
}
