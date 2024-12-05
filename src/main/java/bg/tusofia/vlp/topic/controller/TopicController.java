package bg.tusofia.vlp.topic.controller;

import bg.tusofia.vlp.topic.dto.TopicCreateDto;
import bg.tusofia.vlp.topic.dto.TopicOverviewDto;
import bg.tusofia.vlp.topic.dto.TopicUpdateDto;
import bg.tusofia.vlp.topic.service.TopicService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * Class: TopicController
 *
 * @author Ivan Simeonov
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = "/api/v1/topics", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController {

    private final TopicService topicService;

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicOverviewDto> getTopicById(@PathVariable Long topicId) {
        return ResponseEntity.ok(topicService.getTopicOverviewById(topicId));
    }

    @GetMapping
    public ResponseEntity<Page<TopicOverviewDto>> getAllTopics(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection,
            @RequestParam(defaultValue = "") String searchTerm
            )
    {
        PageRequest pageRequest = PageRequest.of(
                pageNumber,
                pageSize,
                sortDirection.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending()
        );
        return ResponseEntity.ok(topicService.getAllTopicOverviews(searchTerm, pageRequest));
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
