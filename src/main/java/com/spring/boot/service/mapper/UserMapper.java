package com.spring.boot.service.mapper;

import com.spring.boot.dto.ReviewDto;
import com.spring.boot.dto.UserRequestDto;
import com.spring.boot.dto.UserResponseDto;
import com.spring.boot.model.User;
import com.spring.boot.service.RoleService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final String USER_ROLE = "USER";
    private static final String DEFAULT_PASSWORD = "1111";
    private final RoleService roleService;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserMapper(RoleService roleService, BCryptPasswordEncoder encoder) {
        this.roleService = roleService;
        this.encoder = encoder;
    }

    public List<User> mapAll(List<ReviewDto> reviews) {
        return reviews.stream()
                .map(this::reviewDtoToUser)
                .collect(Collectors.toList());
    }

    public User reviewDtoToUser(ReviewDto dto) {
        User user = new User();
        user.setName(dto.getProfileName());
        user.setPassword(encoder.encode(DEFAULT_PASSWORD));
        user.setExternalId(dto.getUserId());
        user.setHelpfulnessNumerator(Long.parseLong(dto.getHelpfulnessNumerator()));
        user.setHelpfulnessDenominator(Long.parseLong(dto.getHelpfulnessDenominator()));
        user.setRoles(Set.of(roleService.getByRoleName(USER_ROLE)));
        return user;
    }

    public User userDtoToUser(UserRequestDto dto) {
        return User.builder()
                .name(dto.getName())
                .password(encoder.encode(dto.getPassword()))
                .build();
    }

    public UserResponseDto userToUserDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }
}
