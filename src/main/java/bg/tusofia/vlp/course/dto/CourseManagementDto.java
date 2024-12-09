package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;

/**
 * Record: CourseFullDto
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseManagementDto(Long id, String title, TopicOverviewDto topic, DifficultyLevel difficultyLevel,
                                  UserOverviewDto author, String status, String modificationDate, int totalStudents, int totalLectures) {
}
