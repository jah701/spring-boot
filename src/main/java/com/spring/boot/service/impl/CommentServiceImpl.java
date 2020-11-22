package com.spring.boot.service.impl;

import com.spring.boot.model.Comment;
import com.spring.boot.repository.CommentRepository;
import com.spring.boot.service.CommentService;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getProductComments(String productId) {
        return commentRepository.getProductComments(productId)
                .stream()
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getMostUsedWordsFromComments(int amount) {
        StringBuilder wordsFromRepository = new StringBuilder();
        commentRepository
                .getAllWords()
                .forEach(wordsFromRepository::append);

        String[] splitWords = wordsFromRepository
                .toString()
                .toLowerCase()
                .split("\\W+");

        Map<String, List<String>> words = getGroupedMap(splitWords);

        Map<String, List<String>> collect = getSortedMap(words);

        return getLimitedResultList(collect, amount);
    }

    private Map<String, List<String>> getGroupedMap(String[] wordsArray) {
        return Arrays.stream(wordsArray)
                .collect(Collectors.groupingBy(word -> word));
    }

    private Map<String, List<String>> getSortedMap(Map<String, List<String>> map) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(List::size)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private List<String> getLimitedResultList(Map<String, List<String>> map, int limit) {
        return map.keySet().stream()
                .sorted(Comparator.comparingInt(e -> map.get(e).size()).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }
}
