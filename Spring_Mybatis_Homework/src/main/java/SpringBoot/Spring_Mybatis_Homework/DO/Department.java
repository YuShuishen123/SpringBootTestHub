package SpringBoot.Spring_Mybatis_Homework.DO;

import lombok.Data;

import java.util.List;

/**
 * @author Yu'S'hui'shen
 */
@Data
public class Department {
    private Integer deptId;
    private String deptName;
    private String location;

    private List<Department> employees;
}
