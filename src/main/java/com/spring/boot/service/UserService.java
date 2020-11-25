package com.spring.boot.service;

import com.spring.boot.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void add(User user);

    void addAll(List<User> users);

    List<Optional<User>> getMostActiveUsers();
}
