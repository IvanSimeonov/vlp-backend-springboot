package bg.tusofia.vlp.notification.mapper;

import bg.tusofia.vlp.notification.domain.Notification;
import bg.tusofia.vlp.notification.dto.NotificationDto;
import bg.tusofia.vlp.notification.dto.TeacherAccessRequestNotificationDto;
import org.mapstruct.Mapper;

/**
 * Interface: NotificationMapper
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Mapper
public interface NotificationMapper {
    NotificationDto notificaitonToNotificationDto(Notification notification);
    TeacherAccessRequestNotificationDto notificationToTeacherAccessRequestNotificationDto(Notification notification);
}
