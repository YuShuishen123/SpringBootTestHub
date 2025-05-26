package springboot.spring_data_jpa.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_name", nullable = false, length = 100)
    private String courseName;

    @Column(name = "credit", nullable = false)
    private Integer credit;

    // 多对多：课程 <-> 学生
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

}