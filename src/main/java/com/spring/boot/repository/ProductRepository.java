package com.spring.boot.repository;

import com.spring.boot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query(value = "SELECT count()",
//            nativeQuery = true)
//    List<String> getMostCommentedProducts();
}
