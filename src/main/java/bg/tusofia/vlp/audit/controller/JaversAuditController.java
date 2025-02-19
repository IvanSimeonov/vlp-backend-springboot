package bg.tusofia.vlp.audit.controller;

import bg.tusofia.vlp.audit.dto.JaversShadowDto;
import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.dto.CourseDto;
import bg.tusofia.vlp.course.mapper.CourseMapper;
import bg.tusofia.vlp.course.repository.CourseRepository;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import bg.tusofia.vlp.user.mapper.UserMapper;
import bg.tusofia.vlp.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.javers.core.Javers;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/audit")
public class JaversAuditController {

  private final Javers javers;
  private final CourseMapper courseMapper;
  private final CourseRepository courseRepository;
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public JaversAuditController(Javers javers,
                               CourseMapper courseMapper,
                               CourseRepository courseRepository,
                               UserMapper userMapper,
                               UserRepository userRepository) {
    this.javers = javers;
    this.courseMapper = courseMapper;
    this.courseRepository = courseRepository;
    this.userMapper = userMapper;
    this.userRepository = userRepository;
  }

  /**
   * Gets all shadows for the entity of the selected type and id
   * <p>
   *
   * @param typeName - full class name of the entity, for example:
   *                 <b>bg.tusofia.vlp.course.domain.Course</b>
   * @param id - identifier of the entity
   * @return
   */
  @GetMapping("/shadows")
  public List<JaversShadowDto> getShadows(@RequestParam String typeName, @RequestParam Long id) {
    return javers.findShadows(QueryBuilder.byInstanceId(id, typeName).build())
        .stream().map(objectShadow -> new JaversShadowDto(
            objectShadow.getCommitMetadata(),
            objectShadow.getCdoSnapshot().getCommitId(),
            objectShadow.getCdoSnapshot().getChanged(),
            objectShadow.getCdoSnapshot().getChanged().stream().map(changedProperty ->
                objectShadow.getCdoSnapshot().getPropertyValue(changedProperty)
            ).toList(),
            objectShadow.getCdoSnapshot().getVersion(),
            objectShadow.getCdoSnapshot().isInitial(),
            id)
        ).toList();
  }

  @GetMapping("/course/{id}")
  @Transactional
  public CourseDto getCourseVersion(@PathVariable Long id, @RequestParam(required = false) Long version) {
    if (version == null) {
      return courseMapper.courseToCourseDto(courseRepository.findCourseById(id).orElse(null));
    }

    // define query
    var query = QueryBuilder.byInstanceId(id, Course.class)
        .withVersion(version)
        .withChildValueObjects(true)
        .withScopeDeepPlus()
        .build();

    var course = (Course) javers.findShadows(query).getFirst().get();

    // find snapshots
    var snapshot = javers.findSnapshots(query);

    // changes
    var changes = javers.findChanges(query);

    return courseMapper.courseToCourseDto(course);
  }

  @GetMapping("/user/{id}")
  @Transactional
  public UserOverviewDto getUserVersion(@PathVariable Long id, @RequestParam(required = false) Long version) {
    if (version == null) {
      return userMapper.userToUserOverviewDto(userRepository.findById(id).orElse(null));
    }
    var user = (User) javers.findShadows(
            QueryBuilder.byInstanceId(id, User.class)
                .withVersion(version)
                .withChildValueObjects(true)
                .withScopeDeepPlus()
                .build()
        )
        .getFirst().get();
    return userMapper.userToUserOverviewDto(user);
  }
}
