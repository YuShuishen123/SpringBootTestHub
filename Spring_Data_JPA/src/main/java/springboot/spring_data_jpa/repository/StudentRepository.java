package springboot.spring_data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.spring_data_jpa.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}