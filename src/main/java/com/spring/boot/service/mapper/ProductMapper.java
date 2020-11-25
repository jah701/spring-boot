package com.spring.boot.service.mapper;

import com.spring.boot.model.Product;
import com.spring.boot.model.dto.Review;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToProduct(Review review) {
        Product product = new Product();
        product.setExternalId(review.getProductId());
        return product;
    }

    public List<Product> mapAll(List<Review> reviews) {
        return reviews.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }
}
