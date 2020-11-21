package com.spring.boot.service.mapper;

import com.spring.boot.model.Product;
import com.spring.boot.model.dto.Review;
import java.util.List;
import java.util.stream.Collectors;

import com.spring.boot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final CommentService commentService;

    @Autowired
    public ProductMapper(CommentService commentService) {
        this.commentService = commentService;
    }

    public Product map(Review review) {
        Product product = new Product();
        product.setExternalId(review.getProductId());
        product.setComments(commentService.getProductComments(review.getProductId()));
        return product;
    }

    public List<Product> mapAll(List<Review> reviews) {
        return reviews.stream()
                .map(this::map)
                .collect(Collectors.toList());
    }
}
