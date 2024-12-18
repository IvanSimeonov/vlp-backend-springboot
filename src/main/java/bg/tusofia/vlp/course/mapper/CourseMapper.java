package bg.tusofia.vlp.course.mapper;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.domain.CourseOverview;
import bg.tusofia.vlp.course.dto.*;
import bg.tusofia.vlp.courserating.domain.CourseRating;
import bg.tusofia.vlp.topic.domain.Topic;
import bg.tusofia.vlp.topic.repository.TopicRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

    private TopicRepository topicRepository;

    /**
     * Maps a CreateCourseDto to a Course entity.
     *
     * @param courseCreateDto The data transfer object to map
     * @return A Course entity representation
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "completedUsers", ignore = true)
    @Mapping(target = "enrolledUsers", ignore = true)
    @Mapping(target = "topic", source = "topicId", qualifiedByName = "mapTopic")
    public abstract Course courseCreateDtoToCourse(CourseCreateDto courseCreateDto);

    /**
     * Maps a Course entity to a CourseManagementDto
     *
     * @param course The course entity to map
     * @return A CourseManagementDto representation with limited data used in the admin management panel
     */
    @Mapping(target = "modificationDate", source = "modified")
    @Mapping(target = "totalStudents", expression = "java(course.getEnrolledUsers().size())")
    public abstract CourseManagementDto courseToCourseManagementDto(Course course);

    @Mapping(target = "averageRating", expression = "java(calculateAverageRating(course))")
    @Mapping(target = "totalRatings", expression = "java(course.getRatings().size())")
    public abstract CourseOverviewDto courseToCourseOverviewDto(Course course);

    @Mapping(target = "topic", source = "topic.title")
    @Mapping(target = "author", expression = "java(course.getAuthor().getFirstName() + \" \" + course.getAuthor().getLastName())")
    @Mapping(target = "totalStudents", expression = "java(course.getEnrolledUsers().size())")
    public abstract CourseUserProfileDto courseToCourseUserProfileDto(Course course);

    /**
     * Maps a CourseOverview to a CourseOverviewDto
     *
     * @param courseOverview The course overview to map
     * @return A CourseOverviewDto representation with limited course details used in most of the paginated courses views.
     */
    @Mapping(target = "averageRating", expression = "java(courseOverview.getAverageRating())")
    @Mapping(target = "totalRatings", expression = "java(courseOverview.getTotalRatings())")
    public abstract CourseOverviewDto courseOverviewToCourseOverviewDto(CourseOverview courseOverview);

    /**
     * Maps a Course entity to a CourseDetailsDto
     *
     * @param course The course entity to map
     * @return A CourseDetailsDto representation with comprehensive course details
     */
    @Mapping(target = "topicOverviewDto", source = "topic")
    @Mapping(target = "totalLectures", expression = "java(course.getLectures().size())")
    @Mapping(target = "totalAssignments", expression = "java(course.getLectures().size())")
    @Mapping(target = "modificationDate", source = "modified")
    public abstract CourseDetailsDto courseToCourseDetailsDto(Course course);

    @Named("mapTopic")
    protected Topic mapTopic(Long topicId) {
        return topicRepository.getReferenceById(topicId);
    }

    @Autowired
    public final void setTopicRepository(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    protected Double calculateAverageRating(Course course) {
        var avg = course.getRatings().stream().mapToInt(CourseRating::getRating).average().orElse(0.0);
        return BigDecimal.valueOf(avg).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
