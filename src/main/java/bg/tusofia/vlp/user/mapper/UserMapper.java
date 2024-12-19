package bg.tusofia.vlp.user.mapper;

import bg.tusofia.vlp.common.domain.UserCompletedCourse;
import bg.tusofia.vlp.common.domain.UserCompletedCourseId;
import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.dto.CourseOverviewDto;
import bg.tusofia.vlp.course.mapper.CourseMapper;
import bg.tusofia.vlp.courserating.domain.CourseRating;
import bg.tusofia.vlp.user.domain.TeacherOverview;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.domain.UserOverview;
import bg.tusofia.vlp.user.dto.TeacherOverviewDto;
import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserPublicProfileDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Interface: UserMapper
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Mapper(uses = CourseMapper.class)
public interface UserMapper {

    User userCreateDtoToUser(UserCreateDto userCreateDto);

    UserOverviewDto userToUserOverviewDto(User user);

    UserOverviewDto userOverviewToUserOverviewDto(UserOverview userOverview);

    @Mapping(target = "isTeacherAccessRequested", source = "teacherAccessRequested")
    @Mapping(target = "completedCourses", source = "completedCourses")
    UserPublicProfileDto userToUserPublicProfileDto(User user);

    TeacherOverviewDto teacherOverviewToTeacherOverviewDto(TeacherOverview teacherOverview);

    default Long map(UserCompletedCourseId userCompletedCourseId) {
        return userCompletedCourseId != null ? userCompletedCourseId.getCourseId() : null;
    }

    @Mapping(target = ".", source = "course")
    @Mapping(target = "averageRating", expression = "java(calculateAverageRating(userCompletedCourse.getCourse()))")
    @Mapping(target = "totalRatings", expression = "java(userCompletedCourse.getCourse().getRatings().size())")
    CourseOverviewDto userCompletedCourseToCourseOverviewDto(UserCompletedCourse userCompletedCourse);

    default Double calculateAverageRating(Course course) {
        var avg = course.getRatings().stream().mapToInt(CourseRating::getRating).average().orElse(0.0);
        return BigDecimal.valueOf(avg).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
