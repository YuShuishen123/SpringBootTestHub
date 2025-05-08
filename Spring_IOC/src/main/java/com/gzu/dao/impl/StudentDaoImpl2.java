package com.gzu.dao.impl;


import com.gzu.dao.StudentDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class StudentDaoImpl2 implements StudentDao, InitializingBean, DisposableBean {

    @Override
    public void save() {
        System.out.println(" dao 2 保存学生信息 ");
    }

    @Override
    public void update() {
        System.out.println(" dao 2 修改学生信息 ");
    }

    // 构造方法
    public StudentDaoImpl2() {
        System.out.println(" dao 2 构造方法执行 ");
    }

    // 实现 InitializingBean 接口的方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(" dao 2 初始化完成 ");
    }

    // 实现 DisposableBean 接口的方法
    @Override
    public void destroy() throws Exception {
        System.out.println(" dao 2 销毁 ");
    }


}
