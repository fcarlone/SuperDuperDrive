package com.frankcarlone.jwdnd.course1.controller;

import com.frankcarlone.jwdnd.course1.model.NoteForm;
import com.frankcarlone.jwdnd.course1.service.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
public class NoteController {

    // Add service
    private NoteService noteService;

    // Constructor
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public String getNotes() {
        return "result";
    }

    @PostMapping
    public String postNote(Authentication authentication, NoteForm noteForm) {
        // look into redirectAttributes argument

        // extract username from authentication and set to note model
        // note.setUsername(authentication.getName());
        String username = authentication.getName();


        System.out.println("note controller username: " + username);
        System.out.println("note: " + noteForm.toString());

        // use note service to add noteForm object
        this.noteService.createNote(noteForm, username);


        // reset note form fields

        // model addAttribute add note to note service



        return "result";
    }
}
