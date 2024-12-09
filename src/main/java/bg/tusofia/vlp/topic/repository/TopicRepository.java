package bg.tusofia.vlp.topic.repository;

import bg.tusofia.vlp.topic.domain.Topic;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import bg.tusofia.vlp.topic.dto.TopicAnalyticsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface: TopicRepository
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Repository
@JaversSpringDataAuditable
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByTitleContainingIgnoreCase(String searchTerm, Pageable pageable);

    @Query("SELECT new bg.tusofia.vlp.topic.dto.TopicAnalyticsDto(t.title, COUNT(c)) " +
    "FROM Topic t LEFT JOIN t.courses c " +
    "GROUP BY t.id, t.title")
    List<TopicAnalyticsDto> findTopicAnalytics();
}
