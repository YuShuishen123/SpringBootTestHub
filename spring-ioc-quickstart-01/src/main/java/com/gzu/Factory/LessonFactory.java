package com.gzu.Factory;

import com.gzu.dao.LessonDao;
import com.gzu.dao.impl.LessonDaoImpl;

public class LessonFactory {

    public LessonDao getLessonDao() {
        return new LessonDaoImpl();
    }
}
