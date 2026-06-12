package com.example.jobsearch.controller;
import com.example.jobsearch.model.User;
import com.example.jobsearch.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }
    @PostMapping("/register")
    public String register(User user) {
        user.setRole("USER");
        userService.register(user);
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            if (user.getRole().equals("ADMIN")) {
                return "redirect:/admin";
            }
            return "redirect:/jobs";
        }
        return "redirect:/login?error";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}