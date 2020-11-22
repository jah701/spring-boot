package com.spring.boot.controller;

import com.spring.boot.model.User;
import com.spring.boot.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/most_active/{amount}")
    public List<User> getMostActiveUsers(@PathVariable int amount) {
        return userService.getMostActiveUsers(amount);
    }
}
