package SpringBoot.Spring_Mybatis_Homework;

import SpringBoot.Spring_Mybatis_Homework.DO.StudentCourse;
import SpringBoot.Spring_Mybatis_Homework.config.SpringConfig;
import SpringBoot.Spring_Mybatis_Homework.service.StudentCourseService;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentCourseServiceTest {


    static Logger logger = LoggerFactory.getLogger(StudentCourseServiceTest.class);

    static final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

    StudentCourseService studentCourseService =  context.getBean(StudentCourseService.class);

    @Test
    @Order(1)
    void insertStudentCourseByStudentIdAndCourseId() {
        int studentId = 50;
        int courseId = 3;
        Date enrollmentDate = new Date();
        int result = studentCourseService.insertStudentCourseByStudentIdAndCourseId(studentId, courseId, enrollmentDate);
        assertEquals(1, result);
        logger.info("插入数据为: {}", studentCourseService.selectStudentCourseByStudentIdAndCourseId(studentId, courseId));
        logger.info("========================================================================");

    }

    @Order(2)
    @Test
    void updateStudentCourseByStudentIdAndCourseId() {
        int studentId = 50;
        int courseId = 3;
        int newCourseId = 5;
        Date enrollmentDate = new Date();
        int result = studentCourseService.updateStudentCourseByStudentIdAndCourseId(studentId, courseId, enrollmentDate, newCourseId);
        assertEquals(1, result);
        logger.info("更新后的数据为:: {}",studentCourseService.selectStudentCourseByStudentIdAndCourseId(studentId, newCourseId));
        logger.info("========================================================================");

    }

    @Test
    @Order(3)
    void selectStudentCourseByStudentIdAndCourseId() {
        int studentId = 50;
        int courseId = 3;
        StudentCourse studentCourse = studentCourseService.selectStudentCourseByStudentIdAndCourseId(studentId, courseId);
        logger.info("查询到的数据为: {}", studentCourse);
        assertThat(studentCourse).isNull();
        logger.info("========================================================================");
    }

    @Order(4)
    @Test
    void deleteStudentCourseByStudentIdAndCourseId() {
        int studentId = 50;
        int courseId = 5;
        int result = studentCourseService.deleteStudentCourseByStudentIdAndCourseId(studentId, courseId);
        logger.info("删除条数为: {}", result);
        // 断言
        assertEquals(1, result);
        logger.info("========================================================================");

    }

    @AfterAll
    static void tearDown() {
        context.close();
        logger.info("容器关闭");
    }
}
