package org.springmvc.dao;

import org.springmvc.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User employee);

    List<User> findAllUsers();

    void updateUser(User employee);

    User getBy(long id);

    User getBy(String login);

    void deleteBy(long id);
}
