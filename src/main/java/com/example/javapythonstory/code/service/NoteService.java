package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Note;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
public interface NoteService extends IService<Note> {

    Integer addNote(Integer userId, Integer modelId, String title, String content);

    Integer updateNote(Integer userId, Integer noteId, String title, String content);

    Integer deleteNote(Integer noteId);

    List<Note> listNoteByUser(Integer userId);

    List<Note> listNoteByUserAndModel(Integer userId, Integer modelId);

    Note queryOneNoteById(Integer noteId);


}
