package com.spring.boot.controller;

import com.spring.boot.model.Word;
import com.spring.boot.service.WordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/words")
public class WordController {
    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/most-used/{amount}")
    public List<Word> getMostUsedWords(@PathVariable int amount) {
        return wordService.getMostUsedWords(amount);
    }
}
