package com.spring.boot.service;

import com.spring.boot.model.Comment;
import java.util.List;

public interface CommentService {
    void add(Comment comment);

    List<Comment> getProductComments(String productId);
}
