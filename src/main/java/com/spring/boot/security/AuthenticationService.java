package com.spring.boot.security;

import com.spring.boot.model.User;

public interface AuthenticationService {
    User register(User user);
}
