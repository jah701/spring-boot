package com.spring.boot.service.impl;

import com.spring.boot.model.Role;
import com.spring.boot.repository.RoleRepository;
import com.spring.boot.service.RoleService;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getByRoleName(String roleName) {
        return roleRepository.getByRoleName(Role.of(roleName).getRoleName())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Can't find role with name '" + roleName + "'"));
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }
}
