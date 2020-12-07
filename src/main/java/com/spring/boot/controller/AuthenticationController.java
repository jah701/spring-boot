package com.spring.boot.controller;

import com.spring.boot.dto.UserRequestDto;
import com.spring.boot.dto.UserResponseDto;
import com.spring.boot.security.AuthenticationService;
import com.spring.boot.service.mapper.UserMapper;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto dto) {
        return userMapper.userToUserDto(
                authenticationService.register(
                        userMapper.userDtoToUser(dto)));
    }
}
