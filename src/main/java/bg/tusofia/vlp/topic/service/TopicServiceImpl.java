package bg.tusofia.vlp.topic.service;

import bg.tusofia.vlp.exception.TopicNotFoundException;
import bg.tusofia.vlp.topic.dto.TopicCreateDto;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.topic.dto.TopicUpdateDto;
import bg.tusofia.vlp.topic.mapper.TopicMapper;
import bg.tusofia.vlp.topic.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class: TopicServiceImpl
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@Service
@RequiredArgsConstructor
@Transactional
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;
    private final TopicMapper topicMapper;

    @Override
    public TopicOverviewDto getTopicOverviewById(Long topicId) {
        return topicMapper.topicToTopicOverviewDto(topicRepository.findById(topicId).orElseThrow(() -> new TopicNotFoundException(topicId)));
    }

    @Override
    public Page<TopicOverviewDto> getAllTopicOverviews(String searchTerm, PageRequest pageRequest) {
        return topicRepository.findByTitleContainingIgnoreCase(searchTerm, pageRequest)
                .map(topicMapper::topicToTopicOverviewDto);
//        return topicRepository.findAll()
//                .stream()
//                .map(topicMapper::topicToTopicOverviewDto)
//                .toList();
    }

    @Override
    public Long createTopic(TopicCreateDto topicCreateDto) {
        var topic = topicMapper.topicCreateDtoToTopic(topicCreateDto);
        return topicRepository.save(topic).getId();
    }

    @Override
    public void updateTopic(Long topicId, TopicUpdateDto topicUpdateDto) {
        var topic = topicRepository.findById(topicId).orElseThrow(() -> new TopicNotFoundException(topicId));
        topic.setTitle(topicUpdateDto.title());
        topic.setDescription(topicUpdateDto.description());
        topicRepository.save(topic);
    }

    @Override
    public void deleteTopicById(Long topicId) {
        var topic = getTopicOverviewById(topicId);
        if (topic.coursesAmount() != 0) {
            throw new IllegalStateException("Cannot delete topic with associated courses!");
        }
        topicRepository.deleteById(topicId);
    }
}
