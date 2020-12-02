package com.spring.boot.service.mapper;

import com.spring.boot.dto.ReviewDto;
import com.spring.boot.model.Product;
import com.spring.boot.service.CommentService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    private final CommentService commentService;

    @Autowired
    public ProductMapper(CommentService commentService) {
        this.commentService = commentService;
    }

    public Product reviewDtoToProduct(ReviewDto review) {
        Product product = new Product();
        product.setExternalId(review.getProductId());
        product.setComments(commentService.getProductComments(review.getProductId()));
        return product;
    }

    public List<Product> mapAll(List<ReviewDto> reviews) {
        return reviews.stream()
                .map(this::reviewDtoToProduct)
                .collect(Collectors.toList());
    }
}
