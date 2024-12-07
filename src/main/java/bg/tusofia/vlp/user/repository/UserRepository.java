package bg.tusofia.vlp.user.repository;

import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.domain.UserOverview;
import bg.tusofia.vlp.user.dto.UserTeacherAccessRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

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

    long countAllByEnabled(boolean enabled);

    long countAllByRoleAndEnabled(RoleType role, boolean enabled);

    @Query("SELECT new bg.tusofia.vlp.user.dto.UserTeacherAccessRequestDto(u.id, u.firstName, u.lastName, u.email) " +
            "FROM User u WHERE u.isTeacherAccessRequested = true AND u.enabled = true")
    Page<UserTeacherAccessRequestDto> findAllUserTeacherAccessRequests(Pageable pageable);
}
