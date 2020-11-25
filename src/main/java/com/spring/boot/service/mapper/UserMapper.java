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
    private final RoleService roleService;

    @Autowired
    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User mapToUser(Review review) {
        User user = new User();
        user.setName(review.getProfileName());
        user.setPassword("1111");
        user.setExternalId(review.getUserId());
        user.setHelpfulnessNumerator(review.getHelpfulnessNumerator());
        user.setHelpfulnessDenominator(review.getHelpfulnessDenominator());
        user.setRoles(Set.of(roleService.getByRoleName("USER")));
        return user;
    }

    public List<User> mapAll(List<Review> reviews) {
        return reviews.stream()
                .map(this::mapToUser)
                .collect(Collectors.toList());
    }
}
