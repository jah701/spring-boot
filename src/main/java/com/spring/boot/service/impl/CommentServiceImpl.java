package com.spring.boot.service.impl;

import com.spring.boot.model.Comment;
import com.spring.boot.repository.CommentRepository;
import com.spring.boot.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getProductComments(String productId) {
        return commentRepository.getProductComments(productId)
                .stream()
                .map(p -> p.get())
                .collect(Collectors.toList());
    }
}
