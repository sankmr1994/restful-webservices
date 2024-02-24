package com.learn.rest.webservices.restfulwebservices.controller;

import com.learn.rest.webservices.restfulwebservices.service.UserService;
import com.learn.rest.webservices.restfulwebservices.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public EntityModel<User> getUser(@PathVariable("id") Integer userId) {
        User user = userService.getUser(userId);
        EntityModel<User> userEntityModel = EntityModel.of(user);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
        userEntityModel.add(linkBuilder.withRel("all-users"));
        return userEntityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.createUser(user);
        URI locationUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{userId}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(locationUri).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") Integer userId) {
        userService.deleteById(userId);
    }
}
