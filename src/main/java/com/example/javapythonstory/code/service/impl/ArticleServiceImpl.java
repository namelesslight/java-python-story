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
        Integer addCode = articleMapper.addArticle(modelId, articleName, articleTitle, articleContent);
        return addCode;
    }

    @Override
    public Integer updateArticle(Integer articleId, String articleTitle, String articleContent) {
        Integer updateCode = articleMapper.updateArticle(articleId, articleTitle, articleContent);
        return updateCode;
    }

    @Override
    public Integer deleteArticle(Integer articleId) {
        Integer deleteCode = articleMapper.deleteArticle(articleId);
        return deleteCode;
    }

    @Override
    public List<Article> listArticleByModel(Integer modelId) {
        List<Article> data = articleMapper.listArticleByModel(modelId);
        return data;
    }

    @Override
    public Article queryOneArticleById(Integer articleId) {
        Article data = articleMapper.queryOneArticleById(articleId);
        return data;
    }
}
