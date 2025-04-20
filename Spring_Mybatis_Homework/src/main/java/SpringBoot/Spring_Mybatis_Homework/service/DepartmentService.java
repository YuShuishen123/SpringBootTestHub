package SpringBoot.Spring_Mybatis_Homework.service;

import SpringBoot.Spring_Mybatis_Homework.DO.Department;

/**
 * @author Yu'S'hui'shen
 */
public interface DepartmentService {

    int insertDepartmentByDeptId(Integer deptId, String deptName, String location);
    int updateDepartmentByDeptId(Integer deptId, String deptName, String location);
    int deleteDepartmentByDeptId(Integer deptId);
    Department selectEmployeesByDeptId(Integer deptId);
}
