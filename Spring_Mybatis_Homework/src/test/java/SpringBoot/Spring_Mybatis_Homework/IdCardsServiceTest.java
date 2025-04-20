package SpringBoot.Spring_Mybatis_Homework;


import SpringBoot.Spring_Mybatis_Homework.DO.IdCard;
import SpringBoot.Spring_Mybatis_Homework.config.SpringConfig;
import SpringBoot.Spring_Mybatis_Homework.service.IdCardService;
import org.junit.jupiter.api.AfterAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IdCardsServiceTest {

    static Logger logger = LoggerFactory.getLogger(IdCardsServiceTest.class);

    static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    IdCardService idCardService = context.getBean(IdCardService.class);

    // 测试插入数据
    @org.junit.jupiter.api.Test
    void insertIdCardByUserId() {

        // 生成测试数据
        String cardNumber = "123456789012345678";
        Date issueDate = new Date();
        Integer userId = 100;
        int result = idCardService.insertIdCardByUserId(userId, cardNumber, issueDate);
        assert result == 1;
        logger.info("插入结果:{}", result);
        assertThat(result).isEqualTo(1);
        // 查询插入的数据行
        logger.info("插入数据为:{}", idCardService.selectIdCardByUserId(userId));
        // 分割线
        logger.info("==============================================================================");
    }

    // 测试查询数据
    @org.junit.jupiter.api.Test
    void selectIdCardByUserId() {
        Integer userId = 100;
        IdCard idCard = idCardService.selectIdCardByUserId(userId);
        logger.info("查询结果:{}", idCard);
        logger.info("查询数据为:{}", idCardService.selectIdCardByUserId(userId));
        assertThat(idCard).isNotNull();
        logger.info("==============================================================================");

    }

    // 测试更新数据
    @org.junit.jupiter.api.Test
    void updateIdCardByUserId() {
        Integer userId = 100;
        String cardNumber = "12345678";
        Date issueDate = new Date();
        int result = idCardService.updateIdCardByUserId(userId, cardNumber, issueDate);
        // 更新结果为:
        logger.info("更新结果:{}", result);
        logger.info("更新结果为:{}", idCardService.selectIdCardByUserId(userId));
        assertEquals(1, result);
        logger.info("==============================================================================");

    }

    // 测试删除数据,此处删除的数据为插入时插入的数据
    @org.junit.jupiter.api.Test
    void deleteIdCardByUserId() {
        int result = idCardService.deleteIdCardByUserId(100);
        assertEquals(1, result);
        logger.info("删除结果:{}", result);
    }

    @AfterAll
    static void tearDown() {
        context.close();
        logger.info("容器关闭");
    }
}
