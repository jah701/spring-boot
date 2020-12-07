package com.spring.boot.service.impl;

import com.spring.boot.model.User;
import com.spring.boot.repository.UserRepository;
import com.spring.boot.service.UserService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getMostActiveUsers(int amount) {
        return userRepository.getMostActiveUsers(PageRequest.of(0, amount))
                .stream()
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findUserByName(name)
                .orElseThrow(() -> new NoSuchElementException(
                        "Can't find user with name " + name));
    }
}
