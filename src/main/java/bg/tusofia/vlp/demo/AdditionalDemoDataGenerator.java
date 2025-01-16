package bg.tusofia.vlp.demo;

import bg.tusofia.vlp.assignment.service.AssignmentSolutionService;
import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.dto.CourseStatusUpdateDto;
import bg.tusofia.vlp.course.service.CourseService;
import bg.tusofia.vlp.lecture.dto.LectureDto;
import bg.tusofia.vlp.lecture.service.LectureService;
import bg.tusofia.vlp.topic.service.TopicService;
import bg.tusofia.vlp.user.domain.RoleType;
import bg.tusofia.vlp.user.domain.User;
import bg.tusofia.vlp.user.domain.UserStatus;
import bg.tusofia.vlp.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.javers.core.Javers;
import org.javers.core.metamodel.object.InstanceId;
import org.javers.repository.jql.JqlQuery;
import org.javers.repository.jql.QueryBuilder;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static bg.tusofia.vlp.course.domain.Status.PUBLISHED;

/**
 * Demo Data Generator component
 * <p>
 * Only active for profile "demo". Adds additional course "Spring Security" with
 * multiple lectures and enrolls users so that changes in Javers can be shown
 */
@Component
@Slf4j
@Profile("demo")
public class AdditionalDemoDataGenerator implements ApplicationListener<ApplicationStartedEvent> {

  private final TopicService topicService;
  private final LectureService lectureService;
  private final CourseService courseService;
  private final UserRepository userRepository;
  private final AssignmentSolutionService assignmentSolutionService;
  private final Javers javers;

  public AdditionalDemoDataGenerator(TopicService topicService,
                                     LectureService lectureService,
                                     CourseService courseService,
                                     UserRepository userRepository,
                                     AssignmentSolutionService assignmentSolutionService,
                                     Javers javers) {
    this.topicService = topicService;
    this.lectureService = lectureService;
    this.courseService = courseService;
    this.userRepository = userRepository;
    this.assignmentSolutionService = assignmentSolutionService;
    this.javers = javers;
  }

  @Override
  public void onApplicationEvent(ApplicationStartedEvent event) {
    log.info("Generating demo data...");
    //var random = new Random();
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


    var usersToBeEnrolled = new String[][] {
        new String[] { "lukas@meyer.com", "Lukas", "Meyer"},
        new String[] { "joe@black.com", "Joe", "Black"},
        new String[] { "wu@lee.com", "Wu", "Lee"},
        new String[] { "tim@schmidt.com", "Tim", "Schmidt"},
        new String[] { "katrin@weiss.com", "Katrin", "Weiss"},
    };
    Arrays.stream(usersToBeEnrolled).forEach(params -> createStudent(params[0], params[1], params[2]));

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

    var lecture1intro = new LectureDto(null,"Getting Started",
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

    var lecture2securityConfig = new LectureDto(null,"Security Configuration I",
        "Changing the default security configurations",
        """
            Understanding about UI part of the EazyBank application.
            Checking the default configuration inside the spring security framework.
            How to disable formLogin and httpBasic authentication.""",
        "https://www.youtube.com/watch?v=XNkV6m4fosw",
        2, springSecurityCourseId
    );

    var lecture3inMemory = new LectureDto(null,"InMemoryUserDetailsManager",
        "Defining and Managing Users using InMemoryUserDetailsManager",
        """
            Configuring users using InMemoryUserDetailsManager.
            Configuring PasswordEncoder using PasswordEncoderFactories.
            Deep Dive of UserDetailsService & UserDetailsManager Interfaces.
            Deep Dive of UserDetails & Authentication interfaces.
            """,
        "https://www.youtube.com/watch?v=XNkV6m4fosw", 3, springSecurityCourseId);

    var lecture4manageUsersInDb = new LectureDto(null,"Database User Management",
        "Defining & Managing Users using a database",
        """
            Understanding JdbcUserDetailsManager & creating Users inside the DB.
            Using JdbcUserDetailsManager to perform authentication.
            Creating our own custom tables for Authentication.
            """,  "https://www.youtube.com/watch?v=d7ZmZFbE_qY", 4, springSecurityCourseId
    );

    var lecture5passwordEncoders = new LectureDto(null, "Password Encoders",
        "Password Management with Password Encoders",
        """
            How our passwords validated with out PasswordEncoders.
            What is Encoding, Decoding & why it is not suitable for passwords management.
            Introduction to Hashing. Drawbacks of Hashing & what are Brute force attacks.
            """,  "https://www.youtube.com/watch?v=d7ZmZFbE_qY", 5, springSecurityCourseId
    );

    var lecture6authenticationProvider = new LectureDto(null, "Authentication Provider",
        "Understanding Authentication Provider and implementing it",
        """
            Why should we consider creating our own AuthenticationProvider
           Understanding AuthenticationProvider methods.
           Implementing and Customizing the AuthenticationProvider inside our application.
           Environment specific Security configurations using Profiles.
            """,  "https://www.youtube.com/watch?v=d7ZmZFbE_qY", 6, springSecurityCourseId
    );


    var lecture1introId = lectureService.createUpdateLecture(lecture1intro);
    var lecture2securityConfigId = lectureService.createUpdateLecture(lecture2securityConfig);
    var lecture3inMemoryId = lectureService.createUpdateLecture(lecture3inMemory);
    var lecture4manageUsersInDbId = lectureService.createUpdateLecture(lecture4manageUsersInDb);
    var lecture5passwordEncodersId = lectureService.createUpdateLecture(lecture5passwordEncoders);
    var lecture6authenticationProviderId = lectureService.createUpdateLecture(lecture6authenticationProvider);

    // PUBLISH THE COURSE!!!
    courseService.updateCourseStatus(springSecurityCourseId, new CourseStatusUpdateDto(PUBLISHED));



    var lectureIdsForAssignments = new LectureDto[] {
        lecture1introId, lecture2securityConfigId, lecture3inMemoryId, lecture4manageUsersInDbId,
        lecture5passwordEncodersId, lecture6authenticationProviderId
    };

    // Enroll users to the course
    for (String[] userParameters: usersToBeEnrolled) {
      mockSecurityContext.loginAsUser(userParameters[0]);
      courseService.enrollUserToCourse(springSecurityCourseId);
    }

    var lecture7 = new LectureDto(null, "7 Provider",
        "Understanding Authentication Provider and implementing it",
        """
            Why should we consider creating our own AuthenticationProvider
           Understanding AuthenticationProvider methods.
           Implementing and Customizing the AuthenticationProvider inside our application.
           Environment specific Security configurations using Profiles.
            """,  "https://www.youtube.com/watch?v=d7ZmZFbE_qY", 7, springSecurityCourseId
    );



    mockSecurityContext.loginAsUser("tim@schmidt.com");
    var userToChange = userRepository.findUserByEmail("tim@schmidt.com").orElse(null);
    userToChange.setFirstName("CHANGED FIRSTNAME");
    userRepository.save(userToChange);

    mockSecurityContext.loginAsUser("michaeljames@iamnewteacher.com");
    lectureService.createUpdateLecture(lecture7);

    //courseService.enrollUserToCourse(springSecurityCourseId);

    // Create random assignments for each user
//            for (String username: usersToBeEnrolled) {
//                mockSecurityContext.loginAsUser(username);
//
//                for (LectureDto lectureDto : lectureIdsForAssignments) {
//                    for (var i = 0; i < random.nextInt(2); i++) {
//                        var solution = new AssignmentSolutionCreateDto(
//                            lectureDto.id(), new DemoMultipartFile(
//                              String.format("%s_lecture_%d_solution_%d", username, lectureDto.id(), i),
//                            String.format("LECTURE %d, SOLUTION %d", lectureDto.id(), i))
//                        );
//                        assignmentSolutionService.uploadAssignmentSolution(solution);
//                    }
//                }
//            }

    log.info("Demo data generation completed.");

    var courseQuery = QueryBuilder.byInstanceId(springSecurityCourseId, Course.class).build();

    var shadows = javers.findShadows(courseQuery);
    var snapshots = javers.findSnapshots(courseQuery);
    var changes = javers.findChanges(courseQuery);

    var obj = shadows.get(0).get();
    log.info("Object is: {}", obj);

  }

  private void createStudent(String email, String firstname, String lastname) {
    var user = new User();
    user.setRole(RoleType.ROLE_STUDENT);
    user.setEnabled(true);
    user.setPassword("$2a$12$9LHpOsnz2RwbioJqCcBGgOHSx9Tn.FfdswODJF.0UzpCOz6VQ0d4u");
    user.setFirstName(firstname);
    user.setLastName(lastname);
    user.setStatus(UserStatus.ACTIVE);
    user.setEmail(email);
    userRepository.save(user);
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
      // NOOP
    }
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
}
