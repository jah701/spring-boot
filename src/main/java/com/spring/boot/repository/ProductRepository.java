package com.spring.boot.repository;

import com.spring.boot.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT c.product_id FROM comments c "
            + "GROUP BY c.product_id "
            + "ORDER BY count(c.product_id) DESC "
            + "LIMIT ?1", nativeQuery = true)
    List<String> getMostCommentedProducts(int amount);
}
