package SpringBoot.Spring_Mybatis_Test.DO;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Employee {
    private Integer empId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobTitle;
    private BigDecimal salary;
    private Integer deptId;
    private Department department;
    private List<Project> projects;
}

