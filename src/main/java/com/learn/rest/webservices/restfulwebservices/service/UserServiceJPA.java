package com.learn.rest.webservices.restfulwebservices.service;

import com.learn.rest.webservices.restfulwebservices.customexception.UserNotFoundException;
import com.learn.rest.webservices.restfulwebservices.repository.UserRepository;
import com.learn.rest.webservices.restfulwebservices.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceJPA {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new UserNotFoundException(String.format("id:%d", userId));
        }
        return user.get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Integer userId) {
        User user = getUser(userId);
        userRepository.deleteById(userId);
    }
}
