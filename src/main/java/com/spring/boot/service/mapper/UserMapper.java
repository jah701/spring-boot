package com.spring.boot.service.mapper;

import com.spring.boot.model.User;
import com.spring.boot.model.dto.Review;
import com.spring.boot.service.RoleService;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final String USER_ROLE = "USER";
    private static final String DEFAULT_PASSWORD = "1111";
    private final RoleService roleService;

    @Autowired
    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User map(Review review) {
        User user = new User();
        user.setName(review.getProfileName());
        user.setPassword(DEFAULT_PASSWORD);
        user.setExternalId(review.getUserId());
        user.setHelpfulnessNumerator(Long.valueOf(review.getHelpfulnessNumerator()));
        user.setHelpfulnessDenominator(Long.valueOf(review.getHelpfulnessDenominator()));
        user.setRoles(Set.of(roleService.getByRoleName(USER_ROLE)));
        return user;
    }

    public List<User> mapAll(List<Review> reviews) {
        return reviews.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
