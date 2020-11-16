package com.spring.boot.model;

import lombok.Data;

@Data
public class Review {
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private String helpfulnessNumerator;
    private String helpfulnessDenominator;
    private Long score;
    private Long time;
    private String summary;
    private String text;
}
