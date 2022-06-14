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
 * @author ZCL
 * @since 2022-06-08
 */
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {

    @Autowired
    private NoteMapper noteMapper;

    /**
     * <p>
     *     添加笔记
     * </p>
     * @param userId 用户编号
     * @param modelId 模块编号
     * @param title 笔记标题
     * @param content 笔记内容
     * @return
     */
    @Override
    public Integer addNote(Integer userId, Integer modelId, String title, String content) {
        Integer addCode = noteMapper.addNote(userId, modelId, title, content);
        return addCode;
    }

    /**
     * <p>
     *     修改笔记
     * </p>
     * @param userId 用户编号
     * @param noteId 笔记编号
     * @param title 笔记标题
     * @param content 笔记内容
     * @return
     */
    @Override
    public Integer updateNote(Integer userId, Integer noteId, String title, String content) {
        Integer updateCode = noteMapper.updateNote(userId, noteId, title, content);
        return updateCode;
    }

    /**
     * <p>
     *     删除笔记
     * </p>
     * @param noteId 笔记编号
     * @return
     */
    @Override
    public Integer deleteNote(Integer noteId) {
        Integer deleteCode = noteMapper.deleteNote(noteId);
        return deleteCode;
    }

    /**
     * <p>
     *     根据用户编号获取笔记
     * </p>
     * @param userId 用户编号
     * @return
     */
    @Override
    public List<Note> listNoteByUser(Integer userId) {
        List<Note> data = noteMapper.listNoteByUser(userId);
        return data;
    }

    /**
     * <p>
     *     根据用户编号和模块编号获取笔记
     * </p>
     * @param userId 用户编号
     * @param modelId 模块编号
     * @return
     */
    @Override
    public List<Note> listNoteByUserAndModel(Integer userId, Integer modelId) {
        List<Note> data = noteMapper.listNoteByUserAndModel(userId, modelId);
        return data;
    }

    /**
     * <p>
     *     根据笔记编号获取笔记
     * </p>
     * @param noteId 笔记编号
     * @return
     */
    @Override
    public Note queryOneNoteById(Integer noteId) {
        Note data = noteMapper.queryOneNoteById(noteId);
        return data;
    }
}
