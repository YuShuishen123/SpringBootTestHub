package SpringBoot.Spring_Mybatis_Homework.service.impl;

import SpringBoot.Spring_Mybatis_Homework.DO.Department;
import SpringBoot.Spring_Mybatis_Homework.mapper.DepartmentMapper;
import SpringBoot.Spring_Mybatis_Homework.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * @author Yu'S'hui'shen
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentMapper departmentMapper;

    public DepartmentServiceImpl(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }
    @Override
    public int insertDepartmentByDeptId(Integer deptId, String deptName, String location) {
        return departmentMapper.insertDepartmentByDeptId(deptId, deptName, location);
    }

    @Override
    public int updateDepartmentByDeptId(Integer deptId, String deptName, String location) {
        return departmentMapper.updateDepartmentByDeptId(deptId, deptName, location);
    }

    @Override
    public int deleteDepartmentByDeptId(Integer deptId) {
        return departmentMapper.deleteDepartmentByDeptId(deptId);
    }

    @Override
    public Department selectEmployeesByDeptId(Integer deptId) {
        if (departmentMapper.selectEmployeesByDeptId(deptId) != null) {
            return departmentMapper.selectEmployeesByDeptId(deptId);
        }
        return null;
    }
}
