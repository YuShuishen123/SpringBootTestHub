package springboot.spring_data_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.spring_data_jpa.model.entity.Employee;
import springboot.spring_data_jpa.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // 获取所有员工
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // 根据ID获取员工
    public Optional<Employee> getEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    // 保存员工
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // 删除员工
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}