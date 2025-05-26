package springboot.spring_data_jpa.service;

import org.springframework.stereotype.Service;
import springboot.spring_data_jpa.model.entity.Course;
import springboot.spring_data_jpa.model.entity.Student;
import springboot.spring_data_jpa.repository.CourseRepository;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // 获取所有课程
    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // 根据ID获取课程
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElse(null);
    }

    // 保存课程
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // 删除课程
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }

    // 添加课程学生
    public Course addStudentToCourse(Integer courseId, Student student) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null && !course.getStudents().contains(student)) {
            course.getStudents().add(student);
            return courseRepository.save(course);
        }
        return null;
    }

    // 移除课程学生
    public Course removeStudentFromCourse(Integer courseId, Student student) {
        Course course = courseRepository.findById(courseId).orElse(null);
        if (course != null && course.getStudents().contains(student)) {
            course.getStudents().remove(student);
            return courseRepository.save(course);
        }
        return null;
    }
}