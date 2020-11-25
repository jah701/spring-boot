package com.spring.boot.repository;

import com.spring.boot.model.Comment;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "SELECT c FROM Comment c "
            + "WHERE c.productId = ?1")
    List<Optional<Comment>> getProductComments(String productId);

    @Query(value = "SELECT c.summary, c.text FROM Comments c",
            nativeQuery = true)
    List<String> getAllWords();
}
