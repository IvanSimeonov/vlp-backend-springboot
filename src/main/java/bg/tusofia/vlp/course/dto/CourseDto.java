package bg.tusofia.vlp.course.dto;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.lecture.dto.LectureDto;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;

import java.util.List;
import java.util.Set;

public record CourseDto(
    Long id,
    String title,
    String shortDescription,
    String fullDescription,
    String requirements,
    Integer totalRatings,
    UserOverviewDto author,
    TopicOverviewDto topicOverviewDto,
    DifficultyLevel difficultyLevel,
    String imagePath,
    Set<LectureDto> lectures,
    int passingScore,
    List<UserOverviewDto> completedUsers,
    Set<UserOverviewDto> enrolledUsers
) {
}
