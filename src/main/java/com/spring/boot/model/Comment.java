package com.spring.boot.model;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private String userId;
    private Long score;
    private Long time;
    @Column(length = 5000)
    private String summary;
    @Column(length = 5000)
    private String text;
    @ManyToMany
    private List<Product> products;
}
