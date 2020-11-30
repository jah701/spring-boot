package com.spring.boot.service.mapper;

import com.spring.boot.model.Word;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class WordMapper {
    public List<Word> mapAllWords(Map<String, Long> words) {
        return words.entrySet().stream()
                .map(e -> Word.builder()
                        .word(String.valueOf(e.getKey()))
                        .amount(e.getValue())
                        .build())
                .collect(Collectors.toList());
    }
}
