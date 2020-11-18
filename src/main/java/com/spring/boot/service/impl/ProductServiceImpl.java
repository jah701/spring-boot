package com.spring.boot.service.impl;

import com.spring.boot.model.Product;
import com.spring.boot.repository.ProductRepository;
import com.spring.boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

//    @Override
//    public List<String> getMostCommentedProducts() {
//        return productRepository.getMostCommentedProducts();
//    }
}