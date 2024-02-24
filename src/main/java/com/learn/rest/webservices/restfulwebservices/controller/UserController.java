package com.learn.rest.webservices.restfulwebservices.controller;

import com.learn.rest.webservices.restfulwebservices.service.UserService;
import com.learn.rest.webservices.restfulwebservices.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Integer userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.createUser(user);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(locationUri).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") Integer userId){
        userService.deleteById(userId);
    }
}
