package com.spring.boot.repository;

import com.spring.boot.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u "
            + "WHERE u.helpfulnessNumerator > 0 "
            + "ORDER BY u.helpfulnessNumerator DESC, u.id DESC")
    List<Optional<User>> getMostActiveUsers(Pageable pageable);

    @Query(value = "SELECT u FROM User u "
            + "JOIN FETCH u.roles "
            + "WHERE u.name = ?1")
    Optional<User> findUserByName(String name);
}
