package springboot.spring_data_jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.spring_data_jpa.model.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}