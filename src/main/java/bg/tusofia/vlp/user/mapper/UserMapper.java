package bg.tusofia.vlp.user.mapper;

import bg.tusofia.vlp.course.mapper.CourseMapper;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.domain.UserOverview;
import bg.tusofia.vlp.user.dto.UserCreateDto;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.dto.UserPublicProfileDto;
import org.mapstruct.Mapper;

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
    UserPublicProfileDto userToUserPublicProfileDto(User user);
}
