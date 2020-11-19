package com.spring.boot.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Review {
    private Long id;
    private String productId;
    private String userId;
    private String profileName;
    private String helpfulnessNumerator;
    private String helpfulnessDenominator;
    private Long score;
    private LocalDateTime time;
    private String summary;
    private String text;
}
