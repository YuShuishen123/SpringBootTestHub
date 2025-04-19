package SpringBoot.Spring_Mybatis_Test;

import SpringBoot.Spring_Mybatis_Test.DO.User;
import SpringBoot.Spring_Mybatis_Test.config.SpringConfig;
import SpringBoot.Spring_Mybatis_Test.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
class UserServiceTests {
    @Test
    void testUser() {
        // 创建容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        // 从容器当中获取UserService
        UserService userService = context.getBean("UserServiceImpl",UserService.class);
        // 初始化一个User对象用于操作
        User user = new User();
        user.setAge(30);
        user.setName("Alice");
        user.setEmail("alice@example.com");
        // 执行插入语句
        int id = userService.insert(user);
        System.out.println("Inserted user ID: " + id);
        // 运用mybatis的插入ID回调机制再次进行查询
        System.out.println(userService.selectById(id));
        // 关闭容器
        context.close();
    }
}
