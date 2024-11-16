package bg.tusofia.vlp.topic.service;

import bg.tusofia.vlp.topic.dto.TopicCreateDto;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.topic.dto.TopicUpdateDto;

import java.util.List;

/**
 * Interface: TopicService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface TopicService {
    TopicOverviewDto getTopicOverviewById(Long topicId);

    List<TopicOverviewDto> getAllTopicOverviews();

    Long createTopic(TopicCreateDto topicCreateDto);

    void updateTopic(Long topicId, TopicUpdateDto topicUpdateDto);

    void deleteTopicById(Long topicId);
}
