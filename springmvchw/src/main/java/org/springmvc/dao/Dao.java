package org.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Data Access Object
//@EnableTransactionManagement
public class Dao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void persist(Object entiry) {
        getSession().persist(entiry);
    }

    public void delele(Object entity) {
        getSession().delete(entity);
    }
}
