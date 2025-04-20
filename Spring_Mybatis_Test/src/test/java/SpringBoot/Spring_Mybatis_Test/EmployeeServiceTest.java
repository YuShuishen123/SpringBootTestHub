package SpringBoot.Spring_Mybatis_Test;

import SpringBoot.Spring_Mybatis_Test.DO.Employee;
import SpringBoot.Spring_Mybatis_Test.config.SpringConfig;
import SpringBoot.Spring_Mybatis_Test.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class EmployeeServiceTest {
    // 获取一个日志实例,用于输出信息
    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceTest.class);
    @Test
    void employeeServiceTestFunction() {
        // 创建容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 从容器当中拿取service
        EmployeeService employeeService = context.getBean(EmployeeService.class);
        // 调用方法
        Employee employee = employeeService.selectEmployeeWithDetails(2);
        // 断言
        assertThat(employee).isNotNull();
        logger.info(employee.toString());
        context.close();
    }

}
