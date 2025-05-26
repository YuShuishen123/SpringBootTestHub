package springboot.spring_data_jpa.controller;

import org.springframework.web.bind.annotation.*;
import springboot.spring_data_jpa.model.entity.Course;
import springboot.spring_data_jpa.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // 获取所有课程
    @GetMapping
    public Iterable<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // 根据ID获取课程
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    // 创建课程
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    // 更新课程
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Integer id, @RequestBody Course courseDetails) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            course.setCourseName(courseDetails.getCourseName());
            course.setCredit(courseDetails.getCredit());
            return courseService.saveCourse(course);
        }
        return null;
    }

    // 删除课程
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
    }
}