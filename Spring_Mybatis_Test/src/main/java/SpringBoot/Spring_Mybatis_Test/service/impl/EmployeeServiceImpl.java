package SpringBoot.Spring_Mybatis_Test.service.impl;

import SpringBoot.Spring_Mybatis_Test.DO.Employee;
import SpringBoot.Spring_Mybatis_Test.Mapper.EmployeeMapper;
import SpringBoot.Spring_Mybatis_Test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee selectEmployeeWithDetails(int empId) {
        return employeeMapper.selectEmployeeWithDetails(empId);
    }
}