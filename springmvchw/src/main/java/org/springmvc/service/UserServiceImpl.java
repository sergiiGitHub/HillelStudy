package org.springmvc.service;

import org.springframework.stereotype.Service;
import org.springmvc.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
public class UserServiceImpl implements UserService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static{
        users = populateDummyUsers();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getBy(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public User getBy(String login) {
        for(User user : users){
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    public void createUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(long id) {
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    public void deleteAllUsers(){
        users.clear();
    }

    public boolean isUserExist(User user) {
        return getBy(user.getLogin())!=null;
    }

    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(counter.incrementAndGet(),"kelly@abc.com", "kelly", 24, 1000));
        users.add(new User(counter.incrementAndGet(),"sanny@abc.com", "sanny", 25, 1001));
        users.add(new User(counter.incrementAndGet(),"perry@abc.com", "perry", 26, 1002));
        return users;
    }

}
