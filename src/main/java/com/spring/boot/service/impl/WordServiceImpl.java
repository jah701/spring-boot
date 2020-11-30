package com.spring.boot.service.impl;

import static java.util.stream.Collectors.counting;

import com.spring.boot.model.Word;
import com.spring.boot.repository.WordRepository;
import com.spring.boot.service.WordService;
import com.spring.boot.service.mapper.WordMapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements WordService {
    private static final String DELIMITER = "\\W+";

    private final WordRepository wordRepository;
    private final WordMapper wordMapper;

    @Autowired
    public WordServiceImpl(WordRepository wordRepository, WordMapper wordMapper) {
        this.wordRepository = wordRepository;
        this.wordMapper = wordMapper;
    }

    @Override
    public void add(Word word) {
        wordRepository.save(word);
    }

    @Override
    public List<Word> getAllMappedWords() {
        List<String> textAndSummary = wordRepository.getTextAndSummary();
        StringBuilder splitTextAndSummary = new StringBuilder();
        for (String s : textAndSummary) {
            splitTextAndSummary
                    .append(s)
                    .append(" ");
        }
        Map<String, Long> mappedWords =
                Arrays.stream(splitTextAndSummary
                            .toString()
                            .toLowerCase()
                            .split(DELIMITER))
                        .collect(Collectors.groupingBy(Function.identity(), counting()));

        return wordMapper.mapAllWords(mappedWords);
    }

    @Override
    public List<Word> getMostUsedWords(int amount) {
        return wordRepository.getMostUsedWords(PageRequest.of(0, amount));
    }
}
