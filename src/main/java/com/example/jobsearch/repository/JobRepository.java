package com.example.jobsearch.repository;
import com.example.jobsearch.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
public interface JobRepository extends JpaRepository<Job, Long> {
}