package org.springmvc.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springmvc.model.User;

import java.util.List;

//@Transactional
@Repository
public class UserDaoImpl extends Dao implements UserDao {


    public void saveUser(User employee) {
        persist(employee);
    }

    @Transactional
    public List<User> findAllUsers() {
        Criteria criteria = getSession().createCriteria(User.class);
        return (List<User>) criteria.list();
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
    }

    @Override
    public User getBy(long id) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));
        return (User) criteria.uniqueResult();
    }

    @Override
    public User getBy(String login) {
        throw new Error();
    }

    @Override
    public void deleteBy(long id) {
        Query query = getSession().createQuery("delete from EMPLOYEE where id = :id");
        query.setLong("id", id);
    }
}
