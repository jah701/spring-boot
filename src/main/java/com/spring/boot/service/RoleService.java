package com.spring.boot.service;

import com.spring.boot.model.Role;

public interface RoleService {
    Role getByRoleName(String roleName);

    void add(Role role);
}
