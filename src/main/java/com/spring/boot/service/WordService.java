package com.spring.boot.service;

import com.spring.boot.model.Word;
import java.util.List;

public interface WordService {
    void add(Word word);

    List<Word> getAllMappedWords();

    List<Word> getMostUsedWords(int amount);
}
