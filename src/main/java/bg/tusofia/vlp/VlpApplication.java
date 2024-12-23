package bg.tusofia.vlp;

import bg.tusofia.vlp.assignment.dto.AssignmentSolutionCreateDto;
import bg.tusofia.vlp.assignment.service.AssignmentSolutionService;
import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseStatusUpdateDto;
import bg.tusofia.vlp.course.service.CourseService;
import bg.tusofia.vlp.lecture.dto.LectureCreateDto;
import bg.tusofia.vlp.lecture.service.LectureService;
import bg.tusofia.vlp.topic.service.TopicService;
import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.domain.UserStatus;
import bg.tusofia.vlp.user.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.javers.core.Javers;
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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

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
                                        PlatformTransactionManager transactionManager,
                                        Javers javers) {
        return args -> {
            var random = new Random();
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

            var csTopic  = topicService.getTopicOverviewById(1L);

            var courseCreateDto = new CourseCreateDto(
                "Spring Security",
                "Spring Security 6, Spring Boot 3, OAUTH2, OpenID Connect, Keycloak...",
                75,
                csTopic.id(),
                DifficultyLevel.INTERMEDIATE,
                "Basic Java and Spring Framework and Spring Boot basic knowledge",
                """
                    Spring Security framework details and it features.
                    How to adapt security for a Java web application using Spring Security
                    What is CSRF, CORS, JWT, OAUTH2
                    Applying authorization rules using roles, authorities inside a web application using Spring Security
                    Method level security in web/non-web applications
                    """,
                mockSecurityContext.getLoggedInUserId()
            );

            var springSecurityCourseId = courseService.createCourse(courseCreateDto);

            var lecture1intro = new LectureCreateDto("Getting Started",
                "Welcome to this course! Let me explain what is the agenda of this course. Also demonstrate what will we build.",
                """
                    Creating a simple Spring Boot app without security.
                    Securing the basic app using static credentials.
                    Funny memes on security.
                    What is security and why it is important.
                    Quick introduction to servlets and filters.
                    """,
                "https://www.youtube.com/watch?v=YeI6Wqn4I78",
                1,
                springSecurityCourseId
            );

            var lecture2securityConfig = new LectureCreateDto("Security Configuration I",
                "Changing the default security configurations",
                """
                    Understanding about UI part of the EazyBank application.
                    Checking the default configuration inside the spring security framework.
                    How to disable formLogin and httpBasic authentication.""",
                "https://www.youtube.com/watch?v=XNkV6m4fosw",
                2, springSecurityCourseId
            );

            var lecture3inMemory = new LectureCreateDto("InMemoryUserDetailsManager",
                "Defining and Managing Users using InMemoryUserDetailsManager",
                """
                    Configuring users using InMemoryUserDetailsManager.
                    Configuring PasswordEncoder using PasswordEncoderFactories.
                    Deep Dive of UserDetailsService & UserDetailsManager Interfaces.
                    Deep Dive of UserDetails & Authentication interfaces.
                    """,
                "https://www.youtube.com/watch?v=XNkV6m4fosw", 3, springSecurityCourseId);

            var lecture4manageUsersInDb = new LectureCreateDto("Database User Management",
                "Defining & Managing Users using a database",
                """
                    Understanding JdbcUserDetailsManager & creating Users inside the DB.
                    Using JdbcUserDetailsManager to perform authentication.
                    Creating our own custom tables for Authentication.
                    """,  "https://www.youtube.com/watch?v=d7ZmZFbE_qY", 4, springSecurityCourseId
                );

            var lecture5passwordEncoders = new LectureCreateDto("Password Encoders",
                "Password Management with Password Encoders",
                """
                    How our passwords validated with out PasswordEncoders.
                    What is Encoding, Decoding & why it is not suitable for passwords management.
                    Introduction to Hashing. Drawbacks of Hashing & what are Brute force attacks.
                    """,  "https://www.youtube.com/watch?v=d7ZmZFbE_qY", 5, springSecurityCourseId
            );

            var lecture6authenticationProvider = new LectureCreateDto("Authentication Provider",
                "Understanding Authentication Provider and implementing it",
                """
                    Why should we consider creating our own AuthenticationProvider
                   Understanding AuthenticationProvider methods.
                   Implementing and Customizing the AuthenticationProvider inside our application.
                   Environment specific Security configurations using Profiles.
                    """,  "https://www.youtube.com/watch?v=d7ZmZFbE_qY", 6, springSecurityCourseId
            );


            var lecture1introId = lectureService.createLecture(lecture1intro);
            var lecture2securityConfigId = lectureService.createLecture(lecture2securityConfig);
            var lecture3inMemoryId = lectureService.createLecture(lecture3inMemory);
            var lecture4manageUsersInDbId = lectureService.createLecture(lecture4manageUsersInDb);
            var lecture5passwordEncodersId = lectureService.createLecture(lecture5passwordEncoders);
            var lecture6authenticationProviderId = lectureService.createLecture(lecture6authenticationProvider);

            // PUBLISH THE COURSE!!!
            courseService.updateCourseStatus(springSecurityCourseId, new CourseStatusUpdateDto(PUBLISHED));

            
            
            var usersToBeEnrolled = new String[] {
                "hans@hofer.com", "sabine@mayer.com",
            "lukas@wagner.com", "julia@bauer.com", "markus@gruber.com", "sophia@huber.com",
            "felix@steiner.com", "emma@berger.com", "paul@maier.com", "laura@wolf.com",
                "simon@weber.com", "anna@schmid.com", "david@schwarz.com", "sarah@koch.com",
                "max@binder.com", "lisa@fuchs.com", "thomas@auer.com", "nina@winkler.com", "christian@moser.com",
            "marie@reiter.com"
            };

            var lectureIdsForAssignments = new Long[] {
                lecture1introId, lecture2securityConfigId, lecture3inMemoryId, lecture4manageUsersInDbId,
                lecture5passwordEncodersId, lecture6authenticationProviderId
            };

            // Enroll users to the course
            for (String username: usersToBeEnrolled) {
                mockSecurityContext.loginAsUser(username);
                courseService.enrollUserToCourse(springSecurityCourseId);
            }


            // Create random assignments for each user
            for (String username: usersToBeEnrolled) {
                mockSecurityContext.loginAsUser(username);

                for (Long lId : lectureIdsForAssignments) {
                    for (var i = 0; i < random.nextInt(6); i++) {
                        var solution = new AssignmentSolutionCreateDto(
                          lId, new DemoMultipartFile(
                              String.format("%s_lecture_%d_solution_%d", username, lId, i),
                            String.format("LECTURE %d, SOLUTION %d", lId, i))
                        );
                        assignmentSolutionService.uploadAssignmentSolution(solution);
                    }
                }

            }
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
