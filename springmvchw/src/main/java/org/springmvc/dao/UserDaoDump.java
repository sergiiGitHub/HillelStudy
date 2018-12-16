package org.springmvc.dao;

import org.springframework.stereotype.Repository;
import org.springmvc.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserDaoDump extends Dao implements UserDao {

    private static final AtomicLong counter = new AtomicLong();

    private static List<User> users;

    static{
        users = populateDummyUsers();
    }

    @Override
    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

    @Override
    public void updateUser(User user) {
        for (int i = 0; i < users.size(); ++i) {
            if (user.getId() == users.get(i).getId()) {
                users.set(i, user);
            }
        }
    }

    @Override
    public User getBy(long id) {
        for (int i = 0; i < users.size(); ++i) {
            if (id == users.get(i).getId()) {
                return users.get(i);
            }
        }
        return null;
    }

    @Override
    public User getBy(String login) {
        throw new Error();
    }

    @Override
    public void deleteBy(long id) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()) {
            User userDb = iterator.next();
            if (userDb.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(counter.incrementAndGet(),"kelly@abc.com", "kelly", 24, 1000));
        users.add(new User(counter.incrementAndGet(),"sanny@abc.com", "sanny", 25, 1001));
        users.add(new User(counter.incrementAndGet(),"perry@abc.com", "perry", 26, 1002));
        return users;
    }
}
