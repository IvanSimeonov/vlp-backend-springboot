package bg.tusofia.vlp.lecture.repository;

import bg.tusofia.vlp.course.domain.Course;
import bg.tusofia.vlp.course.repository.CourseRepository;
import bg.tusofia.vlp.exception.CourseNotFoundException;
import bg.tusofia.vlp.lecture.domain.Lecture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * : LectureRepositoryTest
 *
 * @author Ivan Simeonov
 * @since
 */
@DataJpaTest
class LectureRepositoryTest {

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void testCourseLectureSync() {
        var course = new Course();
        course.setTitle("Test Course");
        course.setDescription("Test Description");
        var savedCourse = courseRepository.save(course);

        var lecture1 = new Lecture();
        lecture1.setTitle("Lecture 1");
        lecture1.setCourse(savedCourse);
        savedCourse.addLecture(lecture1);

        var lecture2 = new Lecture();
        lecture2.setTitle("Lecture 2");
        lecture2.setCourse(savedCourse);
        savedCourse.addLecture(lecture2);

        lectureRepository.save(lecture1);
        lectureRepository.save(lecture2);

        var retrievedCourse = courseRepository.findById(savedCourse.getId()).orElseThrow(() -> new CourseNotFoundException(savedCourse.getId()));
        assertThat(retrievedCourse.getLectures()).hasSize(2);
        assertThat(retrievedCourse.getLectures()).extracting("title").contains("Lecture 1", "Lecture 2");

        var lectureToRemove = retrievedCourse.getLectures().iterator().next();
        retrievedCourse.removeLecture(lectureToRemove);
        lectureRepository.delete(lectureToRemove);

        var updatedCourse = courseRepository.findById(savedCourse.getId()).orElseThrow(() -> new CourseNotFoundException(savedCourse.getId()));
        assertThat(updatedCourse.getLectures()).hasSize(1);
        assertThat(updatedCourse.getLectures()).extracting("title").contains("Lecture 2");

        Optional<Lecture> removedLecture = lectureRepository.findById(lecture1.getId());
        assertThat(removedLecture).isEmpty();
    }

}
