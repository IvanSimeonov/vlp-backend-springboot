package bg.tusofia.vlp.audit.dto;

import org.javers.core.commit.CommitId;
import org.javers.core.commit.CommitMetadata;

import java.util.List;

public record JaversShadowDto(
    CommitMetadata commitMetadata,
    CommitId commitId,
    List<String> changed,

    List<Object> changes,
    Long version,
    Boolean isInitial,
    Long objectId
) {
}
