package com.frankcarlone.jwdnd.course1.controller;

import com.frankcarlone.jwdnd.course1.model.Note;
import com.frankcarlone.jwdnd.course1.model.NoteForm;
import com.frankcarlone.jwdnd.course1.service.NoteService;
import com.frankcarlone.jwdnd.course1.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    // services field
    private NoteService noteService;
    private UserService userService;

    // constructor


    public HomeController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/home")
    public String getHomePage(Authentication authentication, NoteForm noteForm, Model model) {

        // get userId
        String username = authentication.getName();
        int userId = userService.getUser(username).getUserId();
        System.out.println("User ID: " + userId);

        // Notes
        List<Note> notes = this.noteService.getNotesByUser(userId);
        System.out.println("notes: " + notes);

        // Return to template
        model.addAttribute("notes", this.noteService.getNotesByUser(userId));

        return "home";
    }
}
