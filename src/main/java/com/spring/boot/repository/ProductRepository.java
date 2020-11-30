package com.spring.boot.repository;

import com.spring.boot.model.Product;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT c.productId FROM Comment c "
            + "GROUP BY c.productId "
            + "ORDER BY count(c.productId), c.productId DESC")
    List<String> getMostCommentedProducts(Pageable pageable);
}
