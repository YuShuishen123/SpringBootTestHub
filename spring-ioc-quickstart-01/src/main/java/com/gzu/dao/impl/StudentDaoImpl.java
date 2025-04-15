package com.gzu.dao.impl;

import com.gzu.dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void save() {
        System.out.println(" dao 保存学生信息 ");
    }

    @Override
    public void update() {
        System.out.println(" dao 修改学生信息 ");
    }
}
