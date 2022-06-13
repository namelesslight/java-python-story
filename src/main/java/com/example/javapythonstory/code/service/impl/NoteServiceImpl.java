package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Note;
import com.example.javapythonstory.code.mapper.NoteMapper;
import com.example.javapythonstory.code.service.NoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    @Override
    public Integer addNote(Integer userId, Integer modelId, String title, String content) {
        Integer addCode = noteMapper.addNote(userId, modelId, title, content);
        return addCode;
    }

    @Override
    public Integer updateNote(Integer userId, Integer noteId, String title, String content) {
        Integer updateCode = noteMapper.updateNote(userId, noteId, title, content);
        return updateCode;
    }

    @Override
    public Integer deleteNote(Integer noteId) {
        Integer deleteCode = noteMapper.deleteNote(noteId);
        return deleteCode;
    }

    @Override
    public List<Note> listNoteByUser(Integer userId) {
        List<Note> data = noteMapper.listNoteByUser(userId);
        return data;
    }

    @Override
    public List<Note> listNoteByUserAndModel(Integer userId, Integer modelId) {
        List<Note> data = noteMapper.listNoteByUserAndModel(userId, modelId);
        return data;
    }

    @Override
    public Note queryOneNoteById(Integer noteId) {
        Note data = noteMapper.queryOneNoteById(noteId);
        return data;
    }
}
