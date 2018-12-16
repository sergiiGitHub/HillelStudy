package org.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springmvc.dao.UserDao;
import org.springmvc.model.User;

import java.util.List;

/*
+ list of user // dump
+ get user by id
+ get user by login
+ create user
update user by id
delete user by id
delete aall
 */
@Service("userService")
public class UserServiceDb implements UserService {

    @Autowired
    //@Qualifier("userDaoDump")
    @Qualifier("userDaoImpl")
    private UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public User getBy(long id) {
        return userDao.getBy(id);
    }

    @Override
    public User getBy(String login) {
        return userDao.getBy(login);
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserBy(long id) {
        userDao.deleteBy(id);
    }

    @Override
    public boolean isUserExist(User user) {
        return false;
    }

    @Override
    public void deleteAllUsers() {

    }
}
