package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.note.AddNoteDto;
import com.example.javapythonstory.code.entity.dto.note.DeleteNoteDto;
import com.example.javapythonstory.code.entity.dto.note.UpdateNoteDto;
import com.example.javapythonstory.code.entity.po.Note;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/common/addNote")
    public WebResult addNote(@RequestBody AddNoteDto addNoteDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = noteService.addNote(
                addNoteDto.getUserId(),
                addNoteDto.getModelId(),
                addNoteDto.getTitle(),
                addNoteDto.getContent());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/addArticle");
    }

    @PostMapping("/common/updateNote")
    public WebResult updateNote(@RequestBody UpdateNoteDto updateNoteDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = noteService.updateNote(
                updateNoteDto.getUserId(),
                updateNoteDto.getNoteId(),
                updateNoteDto.getTitle(),
                updateNoteDto.getContent());
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/super/updateArticle");
    }

    @PostMapping("/common/deleteNote")
    public WebResult deleteNote(@RequestBody DeleteNoteDto deleteNoteDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = noteService.deleteNote(deleteNoteDto.getNoteId());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/super/deleteArticle");
    }

    @GetMapping("/common/listNoteByUser")
    public WebResult listNoteByUser(@RequestParam Integer userId){
        Map<String, Object> message = new HashMap<>();
        List<Note> data = noteService.listNoteByUser(userId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/listArticleByModel");
    }

    @GetMapping("/common/listNoteByUserAndModel")
    public WebResult listNoteByUserAndModel(@RequestParam Integer userId,
                                            @RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Note> data = noteService.listNoteByUserAndModel(userId, modelId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/queryOneArticleById");
    }

    @GetMapping("/common/queryOneNoteById")
    public WebResult queryOneNoteById(@RequestParam Integer noteId){
        Map<String, Object> message = new HashMap<>();
        Note data = noteService.queryOneNoteById(noteId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/queryOneArticleById");
    }

}
