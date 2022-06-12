package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Article;
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
public interface ArticleService extends IService<Article> {

    Integer addArticle(Integer modelId, String articleName, String articleTitle, String articleContent);

    Integer updateArticle(Integer articleId, String articleTitle, String articleContent);

    Integer deleteArticle(Integer articleId);

    List<Article> listArticleByModel(Integer modelId);

    Article queryOneArticleById(Integer articleId);

}
