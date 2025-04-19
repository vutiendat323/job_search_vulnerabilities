package com.example.jobsearch.service;
import com.example.jobsearch.model.Application;
import com.example.jobsearch.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    public Application apply(Application application) {
        return applicationRepository.save(application);
    }
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}