package org.springmvc.service;


import org.springmvc.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getBy(long id);

    User getBy(String login);

    void createUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    boolean isUserExist(User user) ;

    void deleteAllUsers();
}
