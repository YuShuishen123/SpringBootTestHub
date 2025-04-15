package com.gzu.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


// 测试构造方法注入的循环依赖
@SpringBootTest
@ContextConfiguration(classes = {ServiceAImpl.class, ServiceBImpl.class})
class CircularDependencyTest {

    @Autowired
    private ServiceAImpl serviceA;

    @Autowired
    private ServiceBImpl serviceB;

    //    测试循环依赖
    @Test
    public void testCircularDependency() {
        System.out.println("测试循环依赖");
        serviceA.testA();
        serviceB.testB();
    }

//    使用构造方法注入方式发生错误：
//    java.lang.NullPointerException:
//    Cannot invoke "com.gzu.service.impl.ServiceAImpl.testA()" because "this.serviceA" is null
}
