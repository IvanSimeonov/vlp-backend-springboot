package bg.tusofia.vlp.topic.service;

import bg.tusofia.vlp.topic.dto.TopicCreateDto;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.topic.dto.TopicUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * Interface: TopicService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface TopicService {
    TopicOverviewDto getTopicOverviewById(Long topicId);

    Page<TopicOverviewDto> getAllTopicOverviews(String searchTerm, PageRequest pageRequest);

    Long createTopic(TopicCreateDto topicCreateDto);

    void updateTopic(Long topicId, TopicUpdateDto topicUpdateDto);

    void deleteTopicById(Long topicId);
}
