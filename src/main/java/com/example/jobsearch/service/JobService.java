package com.example.jobsearch.service;
import com.example.jobsearch.model.Job;
import com.example.jobsearch.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }
}