package com.spring.boot.repository;

import com.spring.boot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    @Query(value = "select * from User join ")
//    List<Optional<User>> getMostActiveUsers();
}
