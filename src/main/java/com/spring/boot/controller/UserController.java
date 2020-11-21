package com.spring.boot.controller;

import com.spring.boot.model.User;
import com.spring.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final String DEFAULT_AMOUNT = "1000";

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/most_active/")
    public List<User> getMostActiveUsers(@RequestParam(defaultValue = DEFAULT_AMOUNT) int amount) {
        return userService.getMostActiveUsers(amount);
    }
}
