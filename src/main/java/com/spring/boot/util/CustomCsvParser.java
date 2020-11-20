package com.spring.boot.util;

import com.spring.boot.dto.Review;
import java.util.List;

public interface CustomCsvParser {
    List<Review> csvToReview(String path);
}
