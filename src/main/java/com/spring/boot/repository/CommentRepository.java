package com.spring.boot.repository;

import com.spring.boot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT * FROM comments where product_id = 'productId'", nativeQuery = true)
    List<Optional<Comment>> getProductComments(String productId);
}
