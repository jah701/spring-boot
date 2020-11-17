package com.spring.boot.model.dto;

import javax.persistence.Column;
import lombok.Data;

@Data
public class Review {
    private Long id;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "profile_name")
    private String profileName;
    @Column(name = "helpfulness_numerator")
    private String helpfulnessNumerator;
    @Column(name = "helpfulness_denominator")
    private String helpfulnessDenominator;
    private Long score;
    private Long time;
    private String summary;
    private String text;
}
