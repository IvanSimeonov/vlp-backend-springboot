package bg.tusofia.vlp.audit.controller;

import bg.tusofia.vlp.audit.dto.JaversShadowDto;
import org.javers.core.Javers;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audit")
public class JaversAuditController {

  private final Javers javers;

  public JaversAuditController(Javers javers) {
    this.javers = javers;
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
            objectShadow.getCdoSnapshot().isInitial()))
        .toList();
  }
}
