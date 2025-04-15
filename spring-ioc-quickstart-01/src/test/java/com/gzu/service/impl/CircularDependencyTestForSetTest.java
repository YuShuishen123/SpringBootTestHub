package com.gzu.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

// 测试set方法注入的循环依赖
@SpringBootTest
@ContextConfiguration(classes = {ServiceAImplForSet.class, ServiceBImplForSet.class})
class CircularDependencyTestForSetTest {

    @Autowired
    private ServiceAImplForSet serviceA;
    @Autowired
    private ServiceBImplForSet serviceB;

    //    测试循环依赖
    @Test
    public void testCircularDependency() {
        System.out.println("测试循环依赖开始");
        serviceA.testA();
        serviceB.testB();
    }
//    三级缓存默认关闭，开启需要在配置文件声明
//    spring.main.allow-circular-references=true
//    测试结果：成功
//A无参构造函数
//        B无参构造器
//    在B中注入A
//            在A中注入B
//            测试循环依赖开始
//    在A中测试注入的B的num值：ServiceAImpl.testA
//            numB = 2
//    在B中测试注入的A的num值：ServiceBImpl.testB
//            numA = 1
//    循环依赖解决办法2：循环依赖的Bean使用@Lazy注解
}
