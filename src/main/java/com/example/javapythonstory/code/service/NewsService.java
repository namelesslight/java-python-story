package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.News;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-06-18
 */
public interface NewsService extends IService<News> {

    /**
     * <p>
     *     添加新闻
     * </p>
     * @param title 新闻标题
     * @param content 新闻内容
     * @return
     */
    Integer addNews(String title, String content);

    /**
     * <p>
     *     修改新闻
     * </p>
     * @param newsId 新闻编号
     * @param title 新闻标题
     * @param content 新闻内容
     * @return
     */
    Integer updateNews(Integer newsId, String title, String content);

    /**
     * <p>
     *     删除新闻
     * </p>
     * @param newsId 新闻编号
     * @return
     */
    Integer deleteNews(Integer newsId);

    /**
     * <p>
     *     获取所有新闻
     * </p>
     * @return
     */
    List<News> listNewsByAll();

    /**
     * <p>
     *     随机获取六个新闻
     * </p>
     * @return
     */
    List<News> listNewsByRand();

    /**
     * <p>
     *     根据新闻编号获取单个新闻
     * </p>
     * @param newsId 新闻编号
     * @return
     */
    News queryOneNoteById(Integer newsId);

}
