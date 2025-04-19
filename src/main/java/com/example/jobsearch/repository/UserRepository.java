package com.example.jobsearch.repository;
import com.example.jobsearch.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM User WHERE username = ?1", nativeQuery = true)
    User findByUsername(String username);
}