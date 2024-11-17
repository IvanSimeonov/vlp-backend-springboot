package bg.tusofia.vlp.notification.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * Class: Notification
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Entity(name = "Notification")
@Table(name = "notification")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private Long userId;

    private String message;

    @Column(nullable = false)
    private boolean isRead;

    private Long relatedId;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime modified;
}
