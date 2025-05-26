package springboot.spring_data_jpa.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
class StudentCourseId implements java.io.Serializable {
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "course_id")
    private Integer courseId;
}