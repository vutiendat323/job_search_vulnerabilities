package com.example.jobsearch.controller;
import com.example.jobsearch.model.Job;
import com.example.jobsearch.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class JobController {
    @Autowired
    private JobService jobService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs().stream().limit(3).toList());
        return "index";
    }
    @GetMapping("/jobs")
    public String listJobs(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "jobs";
    }
    @GetMapping("/jobs/{id}")
    public String viewJob(@PathVariable Long id, Model model) {
        Job job = jobService.getJobById(id);
        model.addAttribute("job", job);
        return "job-detail";
    }
    @PostMapping("/jobs/create")
    public String createJob(Job job) {
        jobService.createJob(job);
        return "redirect:/jobs";
    }
}