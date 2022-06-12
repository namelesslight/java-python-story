package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Article;
import com.example.javapythonstory.code.mapper.ArticleMapper;
import com.example.javapythonstory.code.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public Integer addArticle(Integer modelId, String articleName, String articleTitle, String articleContent) {
        return null;
    }

    @Override
    public Integer updateArticle(Integer articleId, String articleTitle, String articleContent) {
        return null;
    }

    @Override
    public Integer deleteArticle(Integer articleId) {
        return null;
    }

    @Override
    public List<Article> listArticleByModel(Integer modelId) {
        return null;
    }

    @Override
    public Article queryOneArticleById(Integer articleId) {
        return null;
    }
}
