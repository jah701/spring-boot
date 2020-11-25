package com.spring.boot.service;

import com.spring.boot.model.Product;
import java.util.List;

public interface ProductService {
    void add(Product product);

    List<String> getMostCommentedProducts(int amount);
}
