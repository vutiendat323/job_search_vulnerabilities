package com.example.jobsearch.repository;
import com.example.jobsearch.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ApplicationRepository extends JpaRepository<Application, Long> {
}