package com.example.jobsearch.controller;
import com.example.jobsearch.model.User;
import com.example.jobsearch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin-dashboard";
    }
    @GetMapping("/admin/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin-users";
    }
    @GetMapping("/admin/users/{id}")
    public String viewUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "admin-user-detail";
    }
}