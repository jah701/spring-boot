package com.spring.boot.service;

import com.spring.boot.model.User;
import java.util.List;

public interface UserService {
    void add(User user);

    List<User> getMostActiveUsers();
}
