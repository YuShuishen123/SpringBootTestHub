package SpringBoot.Spring_Mybatis_Homework.DO;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Yu'S'hui'shen
 */
@Data
public class Employee {
    private Integer empId;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Integer deptId;
}
