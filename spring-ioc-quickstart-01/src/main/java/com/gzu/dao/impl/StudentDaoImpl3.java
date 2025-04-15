package com.gzu.dao.impl;

import com.gzu.dao.StudentDao;
import org.springframework.beans.factory.InitializingBean;

import java.util.Arrays;

public class StudentDaoImpl3 implements StudentDao, InitializingBean{

    // 注入简单类型测试
    private int testA;
    private int[] testNumbers;

    public void setTestA(int testA) {
        System.out.println("StudentDaoImpl3注入属性.setTestA");
        this.testA = testA;
    }

    public void setTestNumbers(int[] testNumbers) {
        System.out.println("StudentDaoImpl3注入属性.setTestNumbers");
        this.testNumbers = testNumbers;
    }

    @Override
    public void save() {
        System.out.println("调用StudentDaoImpl3.save");
        System.out.println("testA = " + testA);
    }

    @Override
    public void update() {
        System.out.println("调用StudentDaoImpl3.update");
        System.out.println("testNumbers = " + Arrays.toString(testNumbers));
    }

    // 构造方法
    public StudentDaoImpl3() {
        System.out.println("调用impl3的无参构造方法：StudentDaoImpl3.StudentDaoImpl3"); // 输出: StudentDaoImpl3.StudentDaoImpl3
    }

    // 实现 InitializingBean 接口的方法
    // 在 Bean 的所有属性被设置（依赖注入完成）之后，Spring 会调用该方法。
    @Override
    public void afterPropertiesSet() throws Exception {  // 初始化方法
        System.out.println("初始化阶段，依赖注入完成后：StudentDAOI：mpl3StudentDaoImpl3.afterPropertiesSet");
    }

    // 自定义初始化方法
    public void customInit() {
        System.out.println("自定义初始化阶段：StudentDaoImpl3.customInit");
    }

    // 实现 DisposableBean 接口的方法
    //    在 Bean 被销毁之前，Spring 会调用该方法。

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("Bean 被销毁之前：StudentDaoImpl3.destroy");
//    }

    // 自定义销毁方法
    public void customDestroy() {
        System.out.println("自定义销毁销毁studentDAOImpl3：StudentDaoImpl3.customDestroy");
    }



}
