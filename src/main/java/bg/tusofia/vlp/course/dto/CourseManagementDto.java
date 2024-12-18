package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.course.domain.Status;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;

/**
 * Record: CourseManagementDto
 * <p>
 * A data transfer object (DTO) that provides a comprehensive overview of a
 * {@link bg.tusofia.vlp.course.domain.Course} entity for administrative management.
 * <p>
 * Designed to support administrative interfaces by presenting key course details
 * including identification, authorship, topic, status, and student engagement metrics.
 *
 * @param id Unique identifier of the course
 * @param title The title of the course
 * @param author Overview of the course author
 * @param topic Overview of the course topic
 * @param difficultyLevel Difficulty classification of the course
 * @param status Current status of the course
 * @param modificationDate Date of the most recent course modification
 * @param totalStudents Number of students enrolled in the course
 * @param totalLectures Number of the lectures in the course
 * @param imagePath File path to the course's representative image
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public record CourseManagementDto(
        Long id,
        String title,
        UserOverviewDto author,
        TopicOverviewDto topic,
        DifficultyLevel difficultyLevel,
        Status status,
        String modificationDate,
        int totalStudents,
        int totalLectures,
        String imagePath) {
}
