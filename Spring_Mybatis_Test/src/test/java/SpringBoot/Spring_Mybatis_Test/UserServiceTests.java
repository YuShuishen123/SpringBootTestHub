package SpringBoot.Spring_Mybatis_Test;


import SpringBoot.Spring_Mybatis_Test.DO.User;
import SpringBoot.Spring_Mybatis_Test.config.SpringConfig;
import SpringBoot.Spring_Mybatis_Test.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author Yu'S'hui'shen
 */

class UserServiceTests {
    private static final Logger log = LoggerFactory.getLogger(UserServiceTests.class);

    @Test
    void UserService() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean("userServiceImpl", UserService.class);
        User user = new User();
        user.setAge(30);
        user.setName("Alice");
        user.setEmail("alice@example.com");
        // 执行插入操作
        int result = userService.insert(user);

        // 添加断言
        assertThat(result).isGreaterThan(0);  // 检查插入是否成功（通常返回受影响的行数）
        assertThat(user.getId()).isNotNull(); // 检查是否生成了ID（假设是自增主键）

        // 可选：验证数据确实插入到了数据库
        User insertedUser = userService.selectById(user.getId());
        assertThat(insertedUser).isNotNull();
        assertThat(insertedUser.getName()).isEqualTo("Alice");

        log.info("Inserted user ID: {}", user.getId());
        context.close();
    }
}
