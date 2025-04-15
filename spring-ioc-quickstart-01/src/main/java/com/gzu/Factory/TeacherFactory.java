package com.gzu.Factory;

import com.gzu.dao.TeacherDao;
import com.gzu.dao.impl.TeacherDaoImpl;

public class TeacherFactory {

    public static TeacherDao getTeacherDao(){

        System.out.println("TeacherFactory生产老师");
        return new TeacherDaoImpl();
    }
}
