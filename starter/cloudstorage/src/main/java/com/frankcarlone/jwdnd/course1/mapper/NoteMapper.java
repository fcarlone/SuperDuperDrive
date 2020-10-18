package com.frankcarlone.jwdnd.course1.mapper;

import com.frankcarlone.jwdnd.course1.model.Note;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface NoteMapper {

    // Select
    @Select("SELECT * FROM NOTES")
    List<Note> getAllNotes();

    @Select("SELECT * FROM NOTES WHERE userid = #{userId}")
    List<Note> getAllUserNotes(int userId);

    // Insert
    @Insert("INSERT INTO NOTES (notetitle, notedescription, userid) VALUES(#{noteTitle}, #{noteDescription}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insertNote(Note note);

    // Delete
    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    void deleteNote(int noteId);

    // Update
    @Update("UPDATE FROM NOTES WHERE noteid = #{noteID}")
    void updateNote(Note note);
}
