package com.frankcarlone.jwdnd.course1.controller;

import com.frankcarlone.jwdnd.course1.model.NoteForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // services field

    // constructor

    @GetMapping("/home")
    public String getHomePage(NoteForm noteForm, Model model) {
        return "home";
    }
}
