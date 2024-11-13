package bg.tusofia.vlp.notification.dto;

import bg.tusofia.vlp.notification.domain.NotificationType;

/**
 * Record: NotificationDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record NotificationDto(NotificationType type, Long userId, String message, boolean isRead) {
}
