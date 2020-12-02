package com.spring.boot.security;

import com.spring.boot.model.User;
import com.spring.boot.service.RoleService;
import com.spring.boot.service.UserService;
import java.util.Set;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

@Log4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User register(User user) {
        user.setRoles(Set.of(roleService.getByRoleName("USER")));
        userService.add(user);
        return user;
    }
}
