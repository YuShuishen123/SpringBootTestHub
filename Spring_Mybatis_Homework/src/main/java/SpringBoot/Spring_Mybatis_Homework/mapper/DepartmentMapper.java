package SpringBoot.Spring_Mybatis_Homework.mapper;

import SpringBoot.Spring_Mybatis_Homework.DO.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yu'S'hui'shen
 */
@Mapper
public interface DepartmentMapper {

    // 一对多关系：部门（departments）与员工（employees）

    // 根据部门id查询该部门所有
    Department selectEmployeesByDeptId(Integer deptId);

    // 修改部门信息
    int updateDepartmentByDeptId(Integer deptId, String deptName, String location);

    // 插入部门
    int insertDepartmentByDeptId(Integer deptId, String deptName, String location);

    // 删除部门
    int deleteDepartmentByDeptId(Integer deptId);


}
