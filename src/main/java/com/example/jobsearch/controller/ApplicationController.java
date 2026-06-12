package com.example.jobsearch.controller;
import com.example.jobsearch.model.Application;
import com.example.jobsearch.model.User;
import com.example.jobsearch.service.ApplicationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Controller
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;
    private final String uploadDir = "src/main/resources/uploads/";
    @PostMapping("/jobs/{jobId}/apply")
    public String apply(@RequestParam("resume") MultipartFile file, @RequestParam("jobId") Long jobId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/login";
        }
        try {
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);
            Files.write(filePath, file.getBytes());
            Application application = new Application();
            application.setUserId(user.getId());
            application.setJobId(jobId);
            application.setResumePath(fileName);
            applicationService.apply(application);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/jobs";
    }
    @GetMapping("/admin/applications")
    public String listApplications(Model model) {
        model.addAttribute("applications", applicationService.getAllApplications());
        return "admin-applications";
    }
    @GetMapping("/uploads/{fileName}")
    public String serveFile(@RequestParam("fileName") String fileName, Model model) {
        model.addAttribute("filePath", "/uploads/" + fileName);
        return "file-view";
    }
}