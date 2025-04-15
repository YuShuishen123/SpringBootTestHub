package com.gzu.dao.impl;

import com.gzu.dao.TeacherDao;

public class TeacherDaoImpl implements TeacherDao {

    @Override
    public void save()
    {
        System.out.println("TeacherDao impl保存老师信息");
    }
}
