package bg.tusofia.vlp;

import bg.tusofia.vlp.assignment.dto.AssignmentSolutionCreateDto;
import bg.tusofia.vlp.assignment.service.AssignmentSolutionService;
import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.course.domain.Status;
import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseStatusUpdateDto;
import bg.tusofia.vlp.course.service.CourseService;
import bg.tusofia.vlp.lecture.domain.Lecture;
import bg.tusofia.vlp.lecture.dto.LectureCreateDto;
import bg.tusofia.vlp.lecture.dto.LectureUpdateDto;
import bg.tusofia.vlp.lecture.service.LectureService;
import bg.tusofia.vlp.topic.dto.TopicCreateDto;
import bg.tusofia.vlp.topic.service.TopicService;
import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.domain.UserStatus;
import bg.tusofia.vlp.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.javers.core.Javers;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static bg.tusofia.vlp.course.domain.Status.PUBLISHED;

@SpringBootApplication
@ConfigurationPropertiesScan
@Slf4j
public class VlpApplication {

    public static void main(String[] args) {
        SpringApplication.run(VlpApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(TopicService topicService,
                                        LectureService lectureService,
                                        CourseService courseService,
                                        UserRepository userRepository,
                                        AssignmentSolutionService assignmentSolutionService,
                                        ObjectMapper objectMapper,
                                        Javers javers) {
        return args -> {
            var mockSecurityContext = new MockSecurityContext(userRepository);
            mockSecurityContext.loginAsUser("root@admin.com");
            var user = new User();
            user.setRole(RoleType.ROLE_TEACHER);
            user.setEnabled(true);
            user.setPassword("$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u");
            user.setFirstName("Michael");
            user.setLastName("James");
            user.setStatus(UserStatus.ACTIVE);
            user.setEmail("michaeljames@iamnewteacher.com");
            userRepository.save(user);

            mockSecurityContext.loginAsUser("michaeljames@iamnewteacher.com");

            var colorTheoryTopic = new TopicCreateDto(
                "Design Basics",
                "This topic will mark all courses for beginners that are related somehow to graphic design"
            );

            var colorTheoryTopicId = topicService.createTopic(colorTheoryTopic);

            var courseCreateDto = new CourseCreateDto(
                "Color theory",
                "Learn theoretical basics of colors and how to combine them to create beautiful images",
                DifficultyLevel.BEGINNER,
                mockSecurityContext.getLoggedInUserId(),
                colorTheoryTopicId,
                Status.DRAFT
            );

            var colorTheoryCourseId = courseService.createCourse(courseCreateDto);

            var colorTheoryIntroLecture = new LectureCreateDto("Color theory introduction",
                "Very basic description of what a color is and how to combine different colors",
                "FULL DESCRIPTION NOT AVAILABLE....".repeat(4),
                "https://www.youtube.com/watch?v=YeI6Wqn4I78",
                1,
                colorTheoryCourseId
            );

            var colorTheoryAdvanced = new LectureCreateDto("Advanced color theory",
                "Advanced strategies to create stunning color combinations",
                ".......".repeat(10),
                "https://www.youtube.com/watch?v=XNkV6m4fosw",
                2, colorTheoryCourseId
            );

            var colorTheoryMaster = new LectureCreateDto("Masterclass color theory",
                "Only for masters",
                "....".repeat(20),
                "https://www.youtube.com/watch?v=XNkV6m4fosw", 3, colorTheoryCourseId);

            var colorTheoryIntoId = lectureService.createLecture(colorTheoryIntroLecture);

            lectureService.updateLecture(colorTheoryIntoId, new LectureUpdateDto(
                colorTheoryIntroLecture.title(),
                "SHORT DESCRIPTION CHANGED!!!",
                colorTheoryIntroLecture.fullDescription(),
                colorTheoryIntroLecture.videoUrl(),
                colorTheoryIntroLecture.sequenceNumber()
            ));

            var colorTheoryAdvancedId = lectureService.createLecture(colorTheoryAdvanced);

            lectureService.createLecture(colorTheoryMaster);

            // PUBLISH THE LECTURE!!!
            courseService.updateCourseStatus(colorTheoryCourseId, new CourseStatusUpdateDto(PUBLISHED));


            // Simulate User login - Hans Hofer (student)
            mockSecurityContext.loginAsUser("hans@hofer.com");
            courseService.enrollUserToCourse(colorTheoryCourseId, mockSecurityContext.getLoggedInUserId());

            var colorTheoryBasicsAssignment1 = new AssignmentSolutionCreateDto(
                colorTheoryIntoId,
                new DemoMultipartFile("color_theory_intro.txt", "Solution 1")
            );

            var colorTheoryBasicsAssignment2 = new AssignmentSolutionCreateDto(
                colorTheoryIntoId,
                new DemoMultipartFile("color_theory_intro.txt", "Solution 2")
            );

            assignmentSolutionService.uploadAssignmentSolution(colorTheoryBasicsAssignment1);
            assignmentSolutionService.uploadAssignmentSolution(colorTheoryBasicsAssignment2);

            var shadows = javers.findShadows(QueryBuilder.byInstanceId(colorTheoryIntoId, Lecture.class).build());
            log.info(shadows.toString());

            var authorShadows = javers.findShadows(QueryBuilder.byInstanceId(colorTheoryIntoId, "bg.tusofia.vlp.lecture.domain.Lecture").byAuthorLikeIgnoreCase("lucas").build());
            log.info(authorShadows.toString());
        };
    }

    /**
     * Demo multipart file
     * <p>
     * Simple MultipartFile implementation to simulate file upload. Emulates simple text files.
     */
    private static class DemoMultipartFile implements MultipartFile {
        private final String name;
        private final String content;

        private DemoMultipartFile(String name, String content) {
            this.name = name;
            this.content = content;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getOriginalFilename() {
            return name;
        }

        @Override
        public String getContentType() {
            return "text/plain";
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public long getSize() {
            return content.getBytes(StandardCharsets.UTF_8).length;
        }

        @Override
        public byte[] getBytes() throws IOException {
            return content.getBytes();
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(content.getBytes());
        }
        @Override
        public void transferTo(File dest) throws IOException, IllegalStateException {
            log.info("Mock transfer to file: {}", dest.getAbsoluteFile());
        }
    }

    private static class MockSecurityContext implements SecurityContext {

        private final UserRepository userRepository;
        private Authentication authentication;
        private Long userId;

        public MockSecurityContext(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public void loginAsUser(String username) {
            var user = this.userRepository.findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("No user with username: %s", username)));
            this.userId = user.getId();
            this.authentication = new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
            SecurityContextHolder.setContext(this);
        }

        public Long getLoggedInUserId() {
            return userId;
        }

        @Override
        public Authentication getAuthentication() {
            return authentication;
        }

        @Override
        public void setAuthentication(Authentication authentication) {

        }
    }
}
