package SpringBoot.Spring_Mybatis_Test.service;

import SpringBoot.Spring_Mybatis_Test.DO.Employee;

public interface EmployeeService {
    Employee selectEmployeeWithDetails(int empId);
}
