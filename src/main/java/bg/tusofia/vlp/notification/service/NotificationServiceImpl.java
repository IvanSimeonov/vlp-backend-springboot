package bg.tusofia.vlp.notification.service;

import bg.tusofia.vlp.exception.NotificationNotFoundException;
import bg.tusofia.vlp.notification.domain.Notification;
import bg.tusofia.vlp.notification.domain.NotificationType;
import bg.tusofia.vlp.notification.dto.NotificationDto;
import bg.tusofia.vlp.notification.mapper.NotificationMapper;
import bg.tusofia.vlp.notification.repository.NotificationRepository;
import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.domain.UserOverview;
import bg.tusofia.vlp.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class: NotificationServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final Map<Long, List<SseEmitter>> emitters = new ConcurrentHashMap<>();
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final UserRepository userRepository;

    @Override
    public SseEmitter subscribe() {
        var userId = getCurrentUser().getId();
        var emitter = new SseEmitter(Long.MAX_VALUE);
        if (emitters.containsKey(userId)) {
            emitters.get(userId).add(emitter);
        } else {
            var sseEmitter = new ArrayList<SseEmitter>();
            sseEmitter.add(emitter);
            emitters.put(userId, sseEmitter);
        }
        emitter.onCompletion(() -> emitters.remove(userId));
        emitter.onTimeout(() -> emitters.remove(userId));
        emitter.onError(e -> emitters.remove(userId));
        broadcastAllNotificationsToRelevantUsers();
        return emitter;
    }

    @Override
    public void createNotification(Long userId, NotificationType notificationType, String message) {
        var notification = Notification.builder()
                .userId(userId)
                .type(notificationType)
                .message(message)
                .isRead(false)
                .build();

        var savedNotification = notificationMapper.notificaitonToNotificationDto(notificationRepository.save(notification));
        broadcastSingleNotificationToRelevantUsers(savedNotification);
    }

    @Override
    public void markNotificationAsRead(Long notificationId) {
        var notification = notificationRepository.findById(notificationId).orElseThrow(
                () -> new NotificationNotFoundException(notificationId)
        );
        notification.setRead(true);
        notificationRepository.save(notification);
        broadcastAllNotificationsToRelevantUsers();
    }

    @Override
    public void markAllNotificationsAsRead() {
        var currentUser = getCurrentUser();
        var notifications = this.notificationRepository.findAllByUserIdOrderByCreatedDesc(currentUser.getId());
        notifications.forEach(notification -> notification.setRead(true));
        this.notificationRepository.saveAll(notifications);
        broadcastAllNotificationsToRelevantUsers();
    }

    private void broadcastSingleNotificationToRelevantUsers(NotificationDto notificationDto) {
        if (notificationDto.type().equals(NotificationType.TEACHER_ACCESS_REQUEST)) {
            var adminUserIds = userRepository.findAllByRoleIn(List.of(RoleType.ROLE_ADMIN, RoleType.ROLE_ROOT_ADMIN))
                    .stream()
                    .map(UserOverview::getId)
                    .toList();
            emitters.forEach((userId, userEmitters) -> {
                if (adminUserIds.contains(userId)) {
                    userEmitters.forEach(emitter -> {
                        try {
                            emitter.send(SseEmitter.event().name("Notification").data(notificationDto));
                        } catch (Exception e) {
                            emitter.completeWithError(e);
                        }
                    });
                }
            });
        } else {
            var userId = notificationDto.userId();
            var userEmitters = emitters.get(userId);
            userEmitters.forEach(emitter -> {
                try {
                    emitter.send(SseEmitter.event().name("Notification").data(notificationDto));
                } catch (Exception e) {
                    emitter.completeWithError(e);
                }
            });
        }
    }

    private void broadcastAllNotificationsToRelevantUsers() {
        var user = getCurrentUser();
        if (isAdminOrRootAdmin(user)) {
            var adminUserIds = userRepository.findAllByRoleIn(List.of(RoleType.ROLE_ADMIN, RoleType.ROLE_ROOT_ADMIN))
                    .stream()
                    .map(UserOverview::getId)
                    .toList();
            emitters.forEach((userId, userEmitters) -> {
                userEmitters.forEach(emitter -> {
                    getUnreadAdminNotifications().forEach(notification -> {
                        if (adminUserIds.contains(userId)) {
                            try {
                                emitter.send(SseEmitter.event().name("Notification").data(notification));
                            } catch (Exception e) {
                                emitter.completeWithError(e);
                            }
                        }
                    });
                });
            });
        } else {
            var userEmitters = emitters.get(user.getId());
            getUnreadNotificationsByUserId(user.getId()).forEach(notification -> userEmitters.forEach(emitter -> {
                try {
                    emitter.send(SseEmitter.event().name("Notification").data(notification));
                } catch (Exception e) {
                    emitter.completeWithError(e);
                }
            }));
        }
    }

    private List<NotificationDto> getUnreadNotificationsByUserId(Long userId) {
        var notifications = notificationRepository.findAllByUserIdOrderByCreatedDesc(userId);
        return notifications
                .stream()
                .map(notificationMapper::notificaitonToNotificationDto)
                .toList();
    }

    private List<NotificationDto> getUnreadAdminNotifications() {
        return notificationRepository.findByTypeInAndIsReadFalse(
                        List.of(NotificationType.TEACHER_ACCESS_REQUEST))
                .stream()
                .map(notificationMapper::notificaitonToNotificationDto)
                .toList();
    }

    private User getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            return (User) authentication.getPrincipal();
        }
        throw new IllegalStateException("Unauthorized access - no valid user context found.");
    }

    private boolean isAdminOrRootAdmin(User user) {
        return user.getRole().equals(RoleType.ROLE_ADMIN) || user.getRole().equals(RoleType.ROLE_ROOT_ADMIN);
    }
}
