package SpringBoot.Spring_Mybatis_Homework.DO;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Yu'S'hui'shen
 */
@Data
public class StudentCourse {
    private Integer studentId;
    private Integer courseId;
    private Date enrollmentDate;

    // 存储学生信息
    private List<Student> students;
    // 存储课程信息
    private List<Course> courses;
}
