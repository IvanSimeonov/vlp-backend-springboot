package bg.tusofia.vlp.topic.controller;

import bg.tusofia.vlp.topic.dto.TopicCreateDto;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.topic.dto.TopicUpdateDto;
import bg.tusofia.vlp.topic.service.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Class: TopicController
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = "/api/v1/topic", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController {

    private final TopicService topicService;

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicOverviewDto> getTopicById(@PathVariable Long topicId) {
        return ResponseEntity.ok(topicService.getTopicOverviewById(topicId));
    }

    @GetMapping
    public ResponseEntity<List<TopicOverviewDto>> getAllTopics() {
        return ResponseEntity.ok(topicService.getAllTopicOverviews());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTopic(@RequestBody @Valid TopicCreateDto topicCreateDto) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{topicId}")
                .buildAndExpand(topicService.createTopic(topicCreateDto))
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{topicId}")
    public ResponseEntity<Void> updateTopic(@PathVariable Long topicId, @RequestBody @Valid TopicUpdateDto topicUpdateDto) {
        topicService.updateTopic(topicId, topicUpdateDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{topicId}")
    public ResponseEntity<Void> deleteTopicById(@PathVariable Long topicId) {
        topicService.deleteTopicById(topicId);
        return ResponseEntity.noContent().build();
    }
}
