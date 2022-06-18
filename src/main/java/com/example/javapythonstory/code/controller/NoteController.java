package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.note.AddNoteDto;
import com.example.javapythonstory.code.entity.dto.note.DeleteNoteDto;
import com.example.javapythonstory.code.entity.dto.note.UpdateNoteDto;
import com.example.javapythonstory.code.entity.po.Note;
import com.example.javapythonstory.code.result.Result;
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
 * @author ZCL
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * <p>
     *     添加笔记
     * </p>
     * @param addNoteDto 添加笔记DTO
     * @return
     */
    @PostMapping("/common/addNote")
    public Result addNote(@RequestBody AddNoteDto addNoteDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = noteService.addNote(
                addNoteDto.getUserId(),
                addNoteDto.getModelId(),
                addNoteDto.getTitle(),
                addNoteDto.getContent());
        message.put("addCode", addCode);
        return new Result().result200(message, "/super/addArticle");
    }

    /**
     * <p>
     *     修改笔记
     * </p>
     * @param updateNoteDto 修改笔记DTO
     * @return
     */
    @PostMapping("/common/updateNote")
    public Result updateNote(@RequestBody UpdateNoteDto updateNoteDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = noteService.updateNote(
                updateNoteDto.getUserId(),
                updateNoteDto.getNoteId(),
                updateNoteDto.getTitle(),
                updateNoteDto.getContent());
        message.put("updateCode", updateCode);
        return new Result().result200(message, "/super/updateArticle");
    }

    /**
     * <p>
     *     删除笔记
     * </p>
     * @param deleteNoteDto 删除笔记DTO
     * @return
     */
    @PostMapping("/common/deleteNote")
    public Result deleteNote(@RequestBody DeleteNoteDto deleteNoteDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = noteService.deleteNote(deleteNoteDto.getNoteId());
        message.put("deleteCode", deleteCode);
        return new Result().result200(message, "/super/deleteArticle");
    }

    /**
     * <p>
     *     根据用户编号获取笔记
     * </p>
     * @param userId 用户编号
     * @return
     */
    @GetMapping("/common/listNoteByUser")
    public Result listNoteByUser(@RequestParam Integer userId){
        Map<String, Object> message = new HashMap<>();
        List<Note> data = noteService.listNoteByUser(userId);
        message.put("data", data);
        return new Result().result200(message, "/common/listArticleByModel");
    }

    /**
     * <p>
     *     根据用户编号和模块编号获取笔记
     * </p>
     * @param userId 用户编号
     * @param modelId 模块编号
     * @return
     */
    @GetMapping("/common/listNoteByUserAndModel")
    public Result listNoteByUserAndModel(@RequestParam Integer userId,
                                         @RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Note> data = noteService.listNoteByUserAndModel(userId, modelId);
        message.put("data", data);
        return new Result().result200(message, "/common/queryOneArticleById");
    }

}
