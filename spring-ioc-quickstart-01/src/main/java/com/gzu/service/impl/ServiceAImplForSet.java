package com.gzu.service.impl;

import com.gzu.service.ServiceA;
import com.gzu.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("ServiceAImplForSet")
public class ServiceAImplForSet implements ServiceA {
    private ServiceB serviceB;

//    A 的无参构造函数
    public ServiceAImplForSet() {
        System.out.println("A无参构造函数");
    }

//    使用set注入
    @Autowired
    @Qualifier("ServiceBImplForSet")
    public void setServiceB(ServiceB serviceB) {
        System.out.println("在A中注入B");
        this.serviceB = serviceB;
    }

    //    在A中测试注入的B的num值
    public void testA(){
        System.out.println("在A中测试注入的B的num值：ServiceAImpl.testA");
        System.out.println("numB = "+ serviceB.getNumB());
    }

    @Override
    public int getNumA() {
        return numA;
    }
}
