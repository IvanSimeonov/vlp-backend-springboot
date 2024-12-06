package bg.tusofia.vlp.topic.service;

import bg.tusofia.vlp.topic.dto.TopicAnalyticsDto;
import bg.tusofia.vlp.topic.dto.TopicCreateDto;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.topic.dto.TopicUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Interface: TopicService
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
public interface TopicService {
    TopicOverviewDto getTopicOverviewById(Long topicId);

    Page<TopicOverviewDto> getAllTopicOverviews(String searchTerm, PageRequest pageRequest);

    /**
     * Retrieves a list of topics analytics, where we can see the amount of courses per topic.
     *
     * @return a list of {@link TopicAnalyticsDto} objects
     *         Note: This method can only be called by an admin user.
     */
    List<TopicAnalyticsDto> getTopicAnalytics();

    Long createTopic(TopicCreateDto topicCreateDto);

    void updateTopic(Long topicId, TopicUpdateDto topicUpdateDto);

    void deleteTopicById(Long topicId);
}
