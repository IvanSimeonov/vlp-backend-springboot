package bg.tusofia.vlp.notification.dto;

import bg.tusofia.vlp.notification.domain.NotificationType;

/**
 * Record: TeacherAccessRequestNotificationDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record TeacherAccessRequestNotificationDto(NotificationType type, String message, boolean isRead) {
}
