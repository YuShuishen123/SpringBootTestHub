package springboot.spring_data_jpa.controller;

import org.springframework.web.bind.annotation.*;
import springboot.spring_data_jpa.model.entity.Department;
import springboot.spring_data_jpa.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // 获取所有部门
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    // 根据ID获取部门
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id).orElse(null);
    }

    // 创建部门
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    // 更新部门
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department departmentDetails) {
        Department department = departmentService.getDepartmentById(id).orElse(null);
        if (department != null) {
            department.setDeptName(departmentDetails.getDeptName());
            department.setLocation(departmentDetails.getLocation());
            return departmentService.saveDepartment(department);
        }
        return null;
    }

    // 删除部门
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
    }
}