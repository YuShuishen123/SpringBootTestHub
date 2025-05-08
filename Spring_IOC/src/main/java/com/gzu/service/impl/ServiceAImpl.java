package com.gzu.service.impl;

import com.gzu.service.ServiceA;
import com.gzu.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class ServiceAImpl implements ServiceA {
    private ServiceB serviceB;
//  构造方法注入
    @Lazy
    @Autowired
    public ServiceAImpl(@Qualifier("serviceBImpl") ServiceB serviceB){
        System.out.println("执行serviceA的带参构造方法:ServiceAImpl.ServiceAImpl");
        this.serviceB = serviceB;
        System.out.println("在A中测试注入的B的num值：ServiceBImpl.testA");
        System.out.println("numB = "+ serviceB.getNumB());
    }
    //    在A中测试注入的B的num值
    public void testA(){
        System.out.println("在A中测试注入的B的num值：ServiceBImpl.testA");
        System.out.println("numB = "+ serviceB.getNumB());
    }

    @Override
    public int getNumA() {
        return numA;
    }
}
