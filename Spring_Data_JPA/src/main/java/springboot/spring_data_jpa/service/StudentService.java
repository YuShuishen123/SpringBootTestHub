package springboot.spring_data_jpa.service;

import org.springframework.stereotype.Service;
import springboot.spring_data_jpa.model.entity.Course;
import springboot.spring_data_jpa.model.entity.Student;
import springboot.spring_data_jpa.repository.StudentRepository;


@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // 获取所有学生
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 根据ID获取学生
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    // 保存学生
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // 删除学生
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    // 添加学生选课
    public Student addCourseToStudent(Integer studentId, Course course) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null && !student.getCourses().contains(course)) {
            student.getCourses().add(course);
            return studentRepository.save(student);
        }
        return null;
    }

    // 移除学生选课
    public Student removeCourseFromStudent(Integer studentId, Course course) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null && student.getCourses().contains(course)) {
            student.getCourses().remove(course);
            return studentRepository.save(student);
        }
        return null;
    }
}