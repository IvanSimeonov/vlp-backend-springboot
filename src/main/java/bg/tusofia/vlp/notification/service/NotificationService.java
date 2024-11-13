package bg.tusofia.vlp.notification.service;

import bg.tusofia.vlp.notification.domain.NotificationType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * Interface: NotificationService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface NotificationService {
    SseEmitter subscribe();
    void createNotification(Long userId, NotificationType notificationType, String message);
    void markNotificationAsRead(Long notificationId);
    void markAllNotificationsAsRead();
}
