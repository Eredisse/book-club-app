package com.learning.bookappbackend.controller;

import com.learning.bookappbackend.model.User;
import com.learning.bookappbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.getAllUsers();
    }

    @PutMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
