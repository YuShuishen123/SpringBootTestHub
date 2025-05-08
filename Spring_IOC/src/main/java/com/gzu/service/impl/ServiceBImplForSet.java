package com.gzu.service.impl;

import com.gzu.service.ServiceA;
import com.gzu.service.ServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ServiceBImplForSet")
public class ServiceBImplForSet implements ServiceB {
    private ServiceA serviceA;

//    无参构造器
    public ServiceBImplForSet(){
        System.out.println("B无参构造器");
    }

//    使用set注入
    @Autowired
    @Qualifier("ServiceAImplForSet")
    public void setServiceA(ServiceA serviceA){
        System.out.println("在B中注入A");
        this.serviceA = serviceA;
    }

    //    在A中测试注入的B的num值
    public void testB(){
        System.out.println("在B中测试注入的A的num值：ServiceBImpl.testB");
        System.out.println("numA = "+ serviceA.getNumA());
    }

    @Override
    public int getNumB() {
        return numB;
    }
}
