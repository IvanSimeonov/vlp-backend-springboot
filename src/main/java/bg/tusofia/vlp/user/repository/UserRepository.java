package bg.tusofia.vlp.user.repository;

import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.domain.UserOverview;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface: UserRepository
 * <p>
 * A repository interface for managing the data access operations for the Course entity.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface UserRepository extends JpaRepository<User, Long> {
    UserOverview findUserOverviewById(Long id);
}
