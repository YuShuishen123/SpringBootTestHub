package com.gzu;

import com.gzu.config.configApplication;
import com.gzu.service.ServiceA;
import com.gzu.service.StudentService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main {

//    初始化：使用@PostConstruct注解或@Bean的initMethod属性。
//    销毁：使用@PreDestroy注解或@Bean的destroyMethod属性。
//    作用域：使用@Scope注解指定Bean的作用域。
//    初始化顺序：使用@DependsOn注解控制Bean的初始化顺序。
//    延迟初始化：使用@Lazy注解延迟Bean的初始化。

//    ● ClassPathXmlApplicationContext是加载XML配置文件
//      ● AnnotationConfigApplicationContext是加载配置类

    public static void main(String[] args) {

//        StudentService service = new StudentServiceImpl();
//        service.save();

//        配置文件中获取应用上下文（IOC容器）
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        从配置类获取应用上下文（IOC容器）
        AnnotationConfigApplicationContext configContext = new AnnotationConfigApplicationContext((configApplication.class));

//        StudentDao studentDao = (StudentDao)context.getBean("studentDaoImpl2");

//        StudentService service2 = (StudentService)context.getBean("studentService");

//        studentDao.save();
//        service2.save();

//        TeacherDao teacherDao = (TeacherDao)context.getBean("teacherDaoName");
//        teacherDao.save();

//        LessonDao lessonDao = (LessonDao)context.getBean("lessonDao");
//
//        lessonDao.save();

//        ScoreDao scoreDao =  (ScoreDao) context.getBean("scoreDao");
//        scoreDao.save();


//        测试bytype自动注入
//        StudentService studentService = (StudentService) context.getBean("studentServiceForAutoWideTest");

//        测试byname自动注入
//        从context当中获取bean
        StudentService studentService = (StudentService) context.getBean("studentServiceForAutoWideTest");
        // 调用 save 方法
        studentService.save();       // 输出: dao 2 保存学生信息
        studentService.update();   // 输出: service 保存学生信息, 然后 dao 2 保存学生信息
//        studentService.testWord();

//        从configApplication配置类中获取bean
        ServiceA studentServiceFromConfig = (ServiceA) configContext.getBean("ServiceAImplForSet");
        System.out.println(studentServiceFromConfig.getNumA());


        // 关闭 Spring 容器
//        context.close();
//        configContext.close();




    }
}