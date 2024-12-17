package bg.tusofia.vlp.lecture.service;

import bg.tusofia.vlp.course.domain.DifficultyLevel;
import bg.tusofia.vlp.course.dto.CourseCreateDto;
import bg.tusofia.vlp.course.service.CourseService;
import bg.tusofia.vlp.exception.LectureNotFoundException;
import bg.tusofia.vlp.lecture.dto.LectureCreateDto;
import bg.tusofia.vlp.security.auth.dto.RegisterRequest;
import bg.tusofia.vlp.security.auth.service.AuthService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.*;

/**
 * : LectureServiceImplIT
 *
 * @author Ivan Simeonov
 * @since
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LectureServiceImplIT {

    @Container
    private static final MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("test")
            .withUsername("root")
            .withPassword("root");

    @Autowired
    private LectureService lectureService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private AuthService authService;

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mysqlContainer::getUsername);
        registry.add("spring.datasource.password", mysqlContainer::getPassword);
    }

    @BeforeAll
    static void startContainer() {
        mysqlContainer.start();
    }

    @AfterAll
    static void stopContainer() {
        mysqlContainer.stop();
    }

    @Test
    @Order(1)
    @Disabled
    void createAndGetLecture() {
        var user = new RegisterRequest("John", "Doe", "john@doe.com", "12345678");
        authService.register(user);
        var courseCreateDto = new CourseCreateDto("Test Course Title", "Test Course Description", 70, 1L, DifficultyLevel.BEGINNER, "No prior knowledge is required", "Extended description", 1L);
        var courseId = courseService.createCourse(courseCreateDto);
        var lectureCreateDto1 = new LectureCreateDto("Test Lecture Title 1", "Short Lecture Description 1", "Full Lecture Description 1", "https://test-video-url.com", 1, courseId);
        var lectureId1 = lectureService.createLecture(lectureCreateDto1);
        var lectureCreateDto2 = new LectureCreateDto("Test Lecture Title 2", "Short Lecture Description 2", "Full Lecture Description 2", "https://test-video-url2.com", 2, courseId);
        var lectureId2 = lectureService.createLecture(lectureCreateDto2);

        var retrievedLecture1 = lectureService.getLectureDetailById(lectureId1);
        var retrievedLecture2 = lectureService.getLectureDetailById(lectureId2);

        assertNotNull(retrievedLecture1);
        assertEquals(lectureCreateDto1.title(), retrievedLecture1.title());
        assertEquals(lectureCreateDto1.fullDescription(), retrievedLecture1.fullDescription());
        assertEquals(lectureCreateDto1.videoUrl(), retrievedLecture1.videoUrl());

        assertNotNull(retrievedLecture2);
        assertEquals(lectureCreateDto2.title(), retrievedLecture2.title());
        assertEquals(lectureCreateDto2.fullDescription(), retrievedLecture2.fullDescription());
        assertEquals(lectureCreateDto2.videoUrl(), retrievedLecture2.videoUrl());

    }

    @Test
    @Order(2)
    @Disabled
    void testDeleteLecture() {
        var courseCreateDto = new CourseCreateDto("Test Course Title", "Test Course Description", 70, 1L, DifficultyLevel.BEGINNER, "No prior knowledge is required", "Extended description", 1L);        var courseId = courseService.createCourse(courseCreateDto);
        var lectureCreateDto = new LectureCreateDto("Test Lecture Title", "Short Lecture Description", "Full Lecture Description", "https://test-video-url.com", 1, courseId);
        var lectureId = lectureService.createLecture(lectureCreateDto);

        lectureService.deleteLecture(lectureId);

        assertThrows(LectureNotFoundException.class, () -> lectureService.getLectureDetailById(lectureId));
    }
}
