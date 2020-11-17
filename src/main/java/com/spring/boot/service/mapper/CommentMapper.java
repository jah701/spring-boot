package com.spring.boot.service.mapper;

import com.spring.boot.model.Comment;
import com.spring.boot.model.dto.Review;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public Comment map(Review review) {
        Comment comment = new Comment();
        comment.setUserId(review.getUserId());
        comment.setScore(review.getScore());
        comment.setSummary(review.getSummary());
        comment.setText(review.getText());
        comment.setTime(review.getTime());
        return comment;
    }

    public List<Comment> mapAll(List<Review> reviews) {
        return reviews.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
