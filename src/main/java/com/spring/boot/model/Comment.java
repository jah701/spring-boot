package com.spring.boot.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "product_id")
    private String productId;
    private Long score;
    private Long time;
    @Column(length = 5000)
    private String summary;
    @Column(length = 5000)
    private String text;
}