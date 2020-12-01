package com.spring.boot.repository;

import com.spring.boot.model.Word;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    @Query(value = "SELECT w FROM Word w "
            + "ORDER BY w.amount DESC")
    List<Word> getMostUsedWords(Pageable pageable);

    @Query(value = "SELECT c.summary, c.text FROM Comment c")
    List<String> getTextAndSummary();
}
