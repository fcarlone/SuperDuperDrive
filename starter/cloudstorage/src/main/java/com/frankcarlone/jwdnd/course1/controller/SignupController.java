package com.frankcarlone.jwdnd.course1.controller;

import com.frankcarlone.jwdnd.course1.model.User;
import com.frankcarlone.jwdnd.course1.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final UserService userService;

    public SignupController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String signupView() {
        return "signup";
    }

    @PostMapping
    public String signupUser(@ModelAttribute User user, Model model) {
        System.out.println("sign up user method");

        // ***Add error handling***

        userService.createUser(user);

        model.addAttribute("signupSuccess", true);

        return "signup";
    }
}
