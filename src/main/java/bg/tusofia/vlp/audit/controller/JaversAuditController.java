package bg.tusofia.vlp.audit.controller;

import bg.tusofia.vlp.audit.dto.JaversShadowDto;
import bg.tusofia.vlp.common.domain.UserCompletedCourse;
import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.dto.CourseDto;
import bg.tusofia.vlp.course.mapper.CourseMapper;
import bg.tusofia.vlp.course.repository.CourseRepository;
import bg.tusofia.vlp.course.service.CourseService;
import bg.tusofia.vlp.lecture.domain.Lecture;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.dto.UserOverviewDto;
import lombok.extern.slf4j.Slf4j;
import org.javers.core.Javers;
import org.javers.core.metamodel.object.InstanceId;
import org.javers.repository.jql.QueryBuilder;
import org.javers.shadow.Shadow;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api/v1/audit")
public class JaversAuditController {

  private final Javers javers;
  private final CourseMapper courseMapper;

  private final CourseRepository courseRepository;

  public JaversAuditController(Javers javers, CourseMapper courseMapper, CourseRepository courseRepository) {
    this.javers = javers;
    this.courseMapper = courseMapper;
    this.courseRepository = courseRepository;
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
    var course = (Course) javers.findShadows(
                QueryBuilder.byInstanceId(id, Course.class)
                    .withVersion(version)
                    .withChildValueObjects(true)
                    .withScopeDeepPlus()
                    .build()
            )
            .getFirst().get();
    return courseMapper.courseToCourseDto(course);
  }
}
