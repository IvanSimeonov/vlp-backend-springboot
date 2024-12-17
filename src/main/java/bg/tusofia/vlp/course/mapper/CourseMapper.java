package bg.tusofia.vlp.course.mapper;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.domain.CourseOverview;
import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseManagementDto;
import bg.tusofia.vlp.course.dto.CourseOverviewDto;
import bg.tusofia.vlp.course.dto.CourseUserProfileDto;
import bg.tusofia.vlp.topic.domain.Topic;
import bg.tusofia.vlp.topic.repository.TopicRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

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
public abstract class CourseMapper {

    @Autowired
    private TopicRepository topicRepository;
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
    @Mapping(target = "topic", source = "topicId", qualifiedByName = "mapTopic")
    public abstract Course courseCreateDtoToCourse(CourseCreateDto courseCreateDto);

    /**
     * Maps a Course entity to a CourseDto.
     *
     * @param course the course entity to map
     * @return a CourseOverviewDto representation
     */
    public abstract CourseOverviewDto courseToCourseOverviewDto(Course course);

    @Mapping(target = "modificationDate", source = "modified")
    @Mapping(target = "totalStudents", expression = "java(course.getEnrolledUsers().size())")
    @Mapping(target = "totalLectures", expression = "java(course.getLectures().size())")
    public abstract CourseManagementDto courseToCourseManagementDto(Course course);

    @Mapping(target = "topic", source = "topic.title")
    @Mapping(target = "author", expression = "java(course.getAuthor().getFirstName() + \" \" + course.getAuthor().getLastName())")
    @Mapping(target = "totalStudents", expression = "java(course.getEnrolledUsers().size())")
    public abstract CourseUserProfileDto courseToCourseUserProfileDto(Course course);

    @Mapping(target = "averageRating", expression = "java(courseOverview.getAverageRating())")
    @Mapping(target = "totalRatings", expression = "java(courseOverview.getTotalRatings())")
    public abstract CourseOverviewDto courseOverviewToCourseOverviewDto(CourseOverview courseOverview);

    @Named("mapTopic")
    protected Topic mapTopic(Long topicId) {
        return topicRepository.getReferenceById(topicId);
    }


}
