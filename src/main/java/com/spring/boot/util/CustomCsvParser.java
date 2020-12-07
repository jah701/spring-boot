package com.spring.boot.util;

import com.spring.boot.dto.ReviewDto;
import java.util.List;

public interface CustomCsvParser {
    List<ReviewDto> csvToReview(String path);
}
