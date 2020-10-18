package com.frankcarlone.jwdnd.course1.service;

import com.frankcarlone.jwdnd.course1.mapper.NoteMapper;
import com.frankcarlone.jwdnd.course1.mapper.UserMapper;
import com.frankcarlone.jwdnd.course1.model.Note;
import com.frankcarlone.jwdnd.course1.model.NoteForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private NoteMapper noteMapper;
    private UserMapper userMapper;

    public NoteService(NoteMapper noteMapper, UserMapper userMapper) {
        this.noteMapper = noteMapper;
        this.userMapper = userMapper;
    }

    // Add note
    public void createNote(NoteForm noteForm, String username) {
        // Create new note
        Note newNote = new Note(null, noteForm.getNoteTitle(), noteForm.getNoteDescription(), userMapper.getUserId(username));
        // Insert note to NoteMapper
        noteMapper.insertNote(newNote);
    }

    // Delete note
    public void deleteNote(int noteId) {
        noteMapper.deleteNote(noteId);
    }

    // Get all user notes
    public List<Note> getNotesByUser(int userId) {
        return noteMapper.getAllUserNotes(userId);
    }

    // Get all notes
    public List<Note> getAllNotes(Note note) {
        System.out.println("Print note toString method: " + note.toString());
        return noteMapper.getAllNotes();
    }

    // Update note
    public void updateNote(NoteForm noteForm, String username) {

        Note updateNote = new Note(
                noteForm.getNoteId(),
                noteForm.getNoteTitle(),
                noteForm.getNoteDescription(),
                userMapper.getUserId(username)
        );

        noteMapper.updateNote(updateNote);
    }
}
