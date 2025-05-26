package springboot.spring_data_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.spring_data_jpa.model.entity.Department;
import springboot.spring_data_jpa.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    // 获取所有部门
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // 根据ID获取部门
    public Optional<Department> getDepartmentById(Integer id) {
        return departmentRepository.findById(id);
    }

    // 保存部门
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // 删除部门
    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}