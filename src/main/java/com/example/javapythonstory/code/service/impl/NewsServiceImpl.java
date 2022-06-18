package com.example.javapythonstory.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javapythonstory.code.entity.po.News;
import com.example.javapythonstory.code.mapper.NewsMapper;
import com.example.javapythonstory.code.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-18
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * <p>
     *     添加新闻
     * </p>
     * @param title 新闻标题
     * @param content 新闻内容
     * @return
     */
    @Override
    public Integer addNews(String title, String content) {
        return newsMapper.addNews(title, content);
    }

    /**
     * <p>
     *     修改新闻
     * </p>
     * @param newsId 新闻编号
     * @param title 新闻标题
     * @param content 新闻内容
     * @return
     */
    @Override
    public Integer updateNews(Integer newsId, String title, String content) {
        return newsMapper.updateNews(newsId, title, content);
    }

    /**
     * <p>
     *     删除新闻
     * </p>
     * @param newsId 新闻编号
     * @return
     */
    @Override
    public Integer deleteNews(Integer newsId) {
        return newsMapper.deleteNews(newsId);
    }

    /**
     * <p>
     *     获取所有新闻
     * </p>
     * @return
     */
    @Override
    public List<News> listNewsByAll() {
        return newsMapper.listNewsByAll();
    }

    /**
     * <p>
     *     随机获取六个新闻
     * </p>
     * @return
     */
    @Override
    public List<News> listNewsByRand() {
        return newsMapper.listNewsByRand();
    }

    /**
     * <p>
     *     根据新闻编号获取单个新闻
     * </p>
     * @param newsId 新闻编号
     * @return
     */
    @Override
    public News queryOneNoteById(Integer newsId) {
        return newsMapper.queryOneNoteById(newsId);
    }
}
