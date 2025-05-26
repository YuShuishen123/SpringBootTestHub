package springboot.spring_data_jpa.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Data
@Entity
@Table(name = "student_courses")
class StudentCourse {
    @EmbeddedId
    private StudentCourseId id;

    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;
}