package com.gzu.Factory;

import com.gzu.dao.ScoreDao;
import com.gzu.dao.impl.ScoreDaoImpl;
import org.springframework.beans.factory.FactoryBean;

public class ScoreDaoFactoryBean implements FactoryBean<ScoreDao> {
    public ScoreDao getObject() throws Exception {
        System.out.println("ScoreDaoFactoryBean...getObject...");
        return new ScoreDaoImpl();
    }

    public Class<?> getObjectType() {
        return ScoreDao.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
