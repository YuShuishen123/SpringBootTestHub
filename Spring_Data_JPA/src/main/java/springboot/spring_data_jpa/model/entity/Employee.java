package springboot.spring_data_jpa.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Yu'S'hui'shen
 */
@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "salary", precision = 10, scale = 2)
    private BigDecimal salary;

    // 多对一：员工 -> 部门
    @ManyToOne
    @JoinColumn(name = "dept_id") // 外键字段
    private Department department;
}