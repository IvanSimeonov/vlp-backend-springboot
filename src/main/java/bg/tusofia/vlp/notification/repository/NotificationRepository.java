package bg.tusofia.vlp.notification.repository;

import bg.tusofia.vlp.notification.domain.Notification;
import bg.tusofia.vlp.notification.domain.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface: NotificationRepository
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserIdAndIsReadFalse(Long recipientId);
    List<Notification> findByUserIdOrderByIdDesc(Long recipientId);
    List<Notification> findByTypeInAndIsReadFalse(List<NotificationType> types);
    List<Notification> findAllByUserIdOrderByCreatedDesc(Long userId);
}
