package com.gzu.service.impl;

import com.gzu.service.ServiceA;
import com.gzu.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ServiceBImpl implements ServiceB {


    private final ServiceA serviceA;

//    构造方法
    @Autowired
    @Lazy
    public ServiceBImpl(@Qualifier("serviceAImpl") ServiceA serviceA) {
        System.out.println("执行serviceB的带参构造方法:ServiceBImpl.ServiceBImpl");
        this.serviceA = serviceA;
    }

//    在B中测试注入的A的num值
    public void testB(){
        System.out.println("在B中测试注入的A的num值：ServiceBImpl.testA");
        System.out.println("numA = "+ serviceA.getNumA());
    }

    public int getNumB() {
        return numB;
    }
}
