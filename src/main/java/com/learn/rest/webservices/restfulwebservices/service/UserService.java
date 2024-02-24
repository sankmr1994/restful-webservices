package com.learn.rest.webservices.restfulwebservices.service;

import com.learn.rest.webservices.restfulwebservices.customexception.UserNotFoundException;
import com.learn.rest.webservices.restfulwebservices.dao.UserDao;
import com.learn.rest.webservices.restfulwebservices.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public User getUser(Integer userId) {
        User user = userDao.findOne(userId);
        if (user == null) {
            throw new UserNotFoundException(String.format("id:%d", userId));
        }
        return user;
    }

    public User createUser(User user) {
        return userDao.save(user);
    }

    public void deleteById(Integer userId) {
        User user = userDao.findOne(userId);
        if (user == null)
            throw new UserNotFoundException(String.format("id:%d", userId));
        userDao.deleteById(userId);
    }
}
