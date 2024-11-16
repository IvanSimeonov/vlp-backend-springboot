package bg.tusofia.vlp.topic.repository;

import bg.tusofia.vlp.topic.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface: TopicRepository
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
