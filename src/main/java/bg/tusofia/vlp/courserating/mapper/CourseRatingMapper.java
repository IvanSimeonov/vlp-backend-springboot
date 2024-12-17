package bg.tusofia.vlp.courserating.mapper;

import bg.tusofia.vlp.courserating.domain.CourseRating;
import bg.tusofia.vlp.courserating.dto.CourseRatingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Interface: CourseRatingMapper
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Mapper
public interface CourseRatingMapper {

    /**
     * Maps a CourseRating entity to a CourseRatingDto
     * @param courseRating The source CourseRating entity
     * @return A CourseRatingDto representing the entity
     */
    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "userId", source = "user.id")
    CourseRatingDto courseRatingToCourseRatingDto(CourseRating courseRating);

    /**
     * Maps a CourseRatingDto to a CourseRating entity
     * @param courseRatingDto The source CourseRatingDto
     * @return A CourseRating entity
     */
    @Mapping(target = "course.id", source = "courseId")
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "user", ignore = true)
    CourseRating courseRatingDtoToCourseRating(CourseRatingDto courseRatingDto);
}
