package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Note;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@Mapper
public interface NoteMapper extends BaseMapper<Note> {

    Integer addNote(Integer userId, Integer modelId, String title, String content);

    Integer updateNote(Integer userId, Integer noteId, String title, String content);

    Integer deleteNote(Integer noteId);

    List<Note> listNoteByUser(Integer userId);

    List<Note> listNoteByUserAndModel(Integer userId, Integer modelId);

    Note queryOneNoteById(Integer noteId);

}
