package bg.tusofia.vlp.user.repository;

import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.TeacherOverview;
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

    @Query("SELECT u.id AS id, " +
            "u.firstName AS firstName, " +
            "u.lastName AS lastName, " +
            "u.email AS email, " +
            "u.profileImagePath AS profileImagePath, " +
            "(SELECT COUNT(DISTINCT e.id) FROM u.createdCourses c " +
            " JOIN c.enrolledUsers e) AS totalEnrolledStudents " +
            "FROM User u " +
            "WHERE u.role = 'ROLE_TEACHER' " +
            "ORDER BY totalEnrolledStudents DESC " +
            "LIMIT 3")
    List<TeacherOverview> findTop3TeachersByEnrolledStudents();
}
