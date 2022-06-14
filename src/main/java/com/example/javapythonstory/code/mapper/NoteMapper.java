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
 * @author ZCL
 * @since 2022-06-08
 */
@Mapper
public interface NoteMapper extends BaseMapper<Note> {

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
    Integer addNote(Integer userId, Integer modelId, String title, String content);

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
    Integer updateNote(Integer userId, Integer noteId, String title, String content);

    /**
     * <p>
     *     删除笔记
     * </p>
     * @param noteId 笔记编号
     * @return
     */
    Integer deleteNote(Integer noteId);

    /**
     * <p>
     *     根据用户编号获取笔记
     * </p>
     * @param userId 用户编号
     * @return
     */
    List<Note> listNoteByUser(Integer userId);

    /**
     * <p>
     *     根据用户编号和模块编号获取笔记
     * </p>
     * @param userId 用户编号
     * @param modelId 模块编号
     * @return
     */
    List<Note> listNoteByUserAndModel(Integer userId, Integer modelId);

    /**
     * <p>
     *     根据笔记编号获取笔记
     * </p>
     * @param noteId 笔记编号
     * @return
     */
    Note queryOneNoteById(Integer noteId);

}
