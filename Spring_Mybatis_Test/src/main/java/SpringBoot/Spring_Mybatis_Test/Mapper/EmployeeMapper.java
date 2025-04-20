package SpringBoot.Spring_Mybatis_Test.Mapper;

import SpringBoot.Spring_Mybatis_Test.DO.Employee;

public interface EmployeeMapper {
    Employee selectEmployeeWithDetails(int empId);
}

