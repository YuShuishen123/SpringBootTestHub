package springboot.spring_data_jpa.controller;

import org.springframework.web.bind.annotation.*;
import springboot.spring_data_jpa.model.entity.Student;
import springboot.spring_data_jpa.service.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 获取所有学生
    @GetMapping
    public Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 根据ID获取学生
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    // 创建学生
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // 更新学生
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            student.setStudentName(studentDetails.getStudentName());
            student.setEnrollmentYear(studentDetails.getEnrollmentYear());
            return studentService.saveStudent(student);
        }
        return null;
    }

    // 删除学生
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}