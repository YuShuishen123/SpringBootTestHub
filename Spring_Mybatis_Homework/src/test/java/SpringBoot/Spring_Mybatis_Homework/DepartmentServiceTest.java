package SpringBoot.Spring_Mybatis_Homework;


import SpringBoot.Spring_Mybatis_Homework.DO.Department;
import SpringBoot.Spring_Mybatis_Homework.config.SpringConfig;
import SpringBoot.Spring_Mybatis_Homework.service.DepartmentService;
import org.junit.jupiter.api.AfterAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class DepartmentServiceTest {

    static Logger logger = LoggerFactory.getLogger(DepartmentServiceTest.class);

    static AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext(SpringConfig.class);

    DepartmentService departmentService = context.getBean(DepartmentService.class);

    @org.junit.jupiter.api.Test
    void insertDepartmentByDeptId() {
        int deptId = 3;
        String deptName = "IT";
        String location = "Beijing";
        int result = departmentService.insertDepartmentByDeptId(deptId, deptName, location);
        // 插入结果为:
        Department department = departmentService.selectEmployeesByDeptId(deptId);
        logger.info("插入的详细数据为 = {}", department);
        logger.info("========================================================================");
        assertEquals(1, result);
    }

    @org.junit.jupiter.api.Test
    void updateDepartmentByDeptId() {
        int deptId = 3;
        String deptName = "Math";
        String location = "WuHan";
        int result = departmentService.updateDepartmentByDeptId(deptId, deptName, location);
        Department department = departmentService.selectEmployeesByDeptId(deptId);
        logger.info("更新详细数据为:{}", department);
        assertEquals(1, result);
        logger.info("========================================================================");

    }

    @org.junit.jupiter.api.Test
    void deleteDepartmentByDeptId() {
        int deptId = 3;
        int result = departmentService.deleteDepartmentByDeptId(deptId);
        logger.info("删除结果为:{}", result);
        assertEquals(1, result);
        logger.info("========================================================================");

    }

    @org.junit.jupiter.api.Test
    void selectEmployeesByDeptId() {
        int deptId = 1;
        Department department = departmentService.selectEmployeesByDeptId(deptId);
        assertEquals(1, department.getDeptId());
        logger.info("查询详细结果为:{}", department);
        logger.info("========================================================================");
    }


    @AfterAll
    static void tearDown() {
        context.close();
        logger.info("容器关闭");
    }

}
