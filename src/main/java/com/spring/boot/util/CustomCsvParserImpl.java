package com.spring.boot.util;

import com.spring.boot.model.Review;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CustomCsvParserImpl implements CustomCsvParser {
    private CSVFormat format;
    private CSVParser csvParser;

    @Override
    public List<Review> csvToReview(String path) {
        List<Review> result = new ArrayList<>();
        try {
            format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
            csvParser = new CSVParser(new FileReader(path), format);
        } catch (IOException e) {
            throw new RuntimeException("Can't parse file. File path: " + path, e);
        }
        for (CSVRecord record : csvParser) {
            Review review = new Review();
            review.setProductId(record.get("ProductId"));
            review.setUserId(record.get("UserId"));
            review.setProfileName(record.get("ProfileName"));
            review.setHelpfulnessNumerator(record.get("HelpfulnessNumerator"));
            review.setHelpfulnessDenominator(record.get("HelpfulnessDenominator"));
            review.setScore(Long.parseLong(record.get("Score")));
            review.setTime(Long.parseLong(record.get("Time")));
            review.setSummary(record.get("Summary"));
            review.setText(record.get("Text"));

            result.add(review);
        }
        return result;
    }
}
