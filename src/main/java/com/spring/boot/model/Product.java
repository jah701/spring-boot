package com.spring.boot.model;

import javax.persistence.*;

import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id")
    private String externalId;
    @OneToMany
    @Column(name = "comment_id")
    private List<Comment> comments;
}
