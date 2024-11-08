package bg.tusofia.vlp.course.mapper;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.domain.CourseOverview;
import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseOverviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Interface: CourseMapper
 * <p>
 * Maps between {@link Course} entity and its DTO representations. Uses MapStruct to generate the implementation at build time.
 * The componentModel attribute set to spring in pom.xml, is used to support Spring and Contexts and Dependency Injection.
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Mapper
public interface CourseMapper {

    //CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    /**
     * Maps a CreateCourseDTO to a Course entity.
     *
     * @param courseCreateDto the data transfer object to map
     * @return a Course entity representation
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "completedUsers", ignore = true)
    @Mapping(target = "enrolledUsers", ignore = true)
    Course courseCreateDtoToCourse(CourseCreateDto courseCreateDto);

    /**
     * Maps a Course entity to a CourseDto.
     *
     * @param course the course entity to map
     * @return a CourseOverviewDto representation
     */
    CourseOverviewDto courseToCourseOverviewDto(Course course);

    CourseOverviewDto courseOverviewToCourseOverviewDto(CourseOverview courseOverview);
}
