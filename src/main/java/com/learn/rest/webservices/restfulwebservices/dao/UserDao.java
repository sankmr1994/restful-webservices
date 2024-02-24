package com.learn.rest.webservices.restfulwebservices.dao;

import com.learn.rest.webservices.restfulwebservices.user.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Repository
public class UserDao {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1,"sandy", LocalDate.now().minusYears(29)));
        users.add(new User(2,"mano", LocalDate.now().minusYears(28)));
        users.add(new User(3,"gogul", LocalDate.now().minusYears(30)));
    }

    public List<User> findAll(){
        return  users;
    }

    public User findOne(Integer userId){
        return users.stream().filter(user -> userId == user.getId()).findFirst().orElse(null);
    }

    public User save(User user) {
        users.add(user);
        return user;
    }

    public void deleteById(Integer userId){
        Predicate<User> userPredicate = user -> user.getId() == userId;
        users.removeIf(userPredicate);
    }
}
