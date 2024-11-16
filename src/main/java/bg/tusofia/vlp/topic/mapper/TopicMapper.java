package bg.tusofia.vlp.topic.mapper;

import bg.tusofia.vlp.topic.domain.Topic;
import bg.tusofia.vlp.topic.dto.TopicCreateDto;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.topic.dto.TopicUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Interface: TopicMapper
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Mapper
public interface TopicMapper {

    @Mapping(target = "coursesAmount", expression = "java(topic.getCourses().size())")
    TopicOverviewDto topicToTopicOverviewDto(Topic topic);

    Topic topicCreateDtoToTopic(TopicCreateDto topic);

    Topic topicUpdateDtoToTopic(TopicUpdateDto topic);

}
