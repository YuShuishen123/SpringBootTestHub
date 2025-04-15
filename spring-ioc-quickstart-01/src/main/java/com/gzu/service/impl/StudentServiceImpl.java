package com.gzu.service.impl;

import com.gzu.dao.StudentDao;
import com.gzu.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao ;
//    private final int testStudentServiceImpl;


//    StudentDao属性setter方法
    public void setStudentDao(StudentDao studentDao) {
        System.out.println("注入studentService中的studentDAO依赖，StudentServiceImpl.setStudentDao");
        this.studentDao = studentDao;
    }


//    打印自身
    public void PrintTestStudentServiceImpl(int testStudentServiceImpl) {
        System.out.println("testStudentServiceImpl = " + testStudentServiceImpl);
    }


//    带参构造方法注入
    public StudentServiceImpl(StudentDao studentDao) {
        System.out.println("StudentServiceImpl.StudentServiceImpl");
        this.studentDao = studentDao;
//        this.testStudentServiceImpl=testStudentServiceImpl;
    }

//    无参构造方法
    public StudentServiceImpl(){
        System.out.println("调用StudentService无参构造方法：StudentServiceImpl.StudentServiceImpl");
    }

    @Override
    public void save() {
        System.out.println("service调用studentDAO 保存学生信息");
        studentDao.save();
    }

    @Override
    public void update() {
        System.out.println("service调用studentDAO 更新学生信息");
        studentDao.update();
    }

}
