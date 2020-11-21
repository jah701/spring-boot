package com.spring.boot.repository;

import com.spring.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM Users u "
            + "WHERE u.helpfulness_Numerator > '0' "
            + "ORDER BY u.helpfulness_Numerator DESC "
            + "LIMIT amount"
            , nativeQuery = true)
    List<Optional<User>> getMostActiveUsers(int amount);
}
