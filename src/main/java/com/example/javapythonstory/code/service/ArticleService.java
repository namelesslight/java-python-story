package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Article;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
public interface ArticleService extends IService<Article> {

    /**
     * <p>
     *     添加文章
     * </p>
     * @param modelId 模块编号
     * @param articleName 文章名
     * @param articleTitle 文章标题
     * @param articleContent 文章内容
     * @return
     */
    Integer addArticle(Integer modelId, String articleName, String articleTitle, String articleContent);

    /**
     * <p>
     *     添加问题
     * </p>
     * @param articleName 文章名
     * @param articleTitle 文章标题
     * @param articleContent 文章内容
     * @return
     */
    Integer addProblem(String articleTitle, String articleName, String articleContent);

    /**
     * <p>
     *     修改文章
     * </p>
     * @param articleId 文章编号
     * @param articleTitle 文章标题
     * @param articleContent 文章内容
     * @return
     */
    Integer updateArticle(Integer articleId, String articleTitle, String articleContent);

    /**
     * <p>
     *     删除文章
     * </p>
     * @param articleId 文章编号
     * @return
     */
    Integer deleteArticle(Integer articleId);

    /**
     * <p>
     *     通过模块获取文章
     * </p>
     * @param modelId 模块编号
     * @return
     */
    List<Article> listArticleByModel(Integer modelId);


    /**
     * <p>
     *     通过编号获取文章
     * </p>
     * @param articleId 文章编号
     * @return
     */
    Article queryOneArticleById(Integer articleId);

    /**
     * <p>
     *     获取问题解决方案
     * </p>
     * @return
     */
    List<Article> listProblem();

    /**
     * <p>
     *     通过关键词获取问题解决方案
     * </p>
     * @param word 关键词
     * @return
     */
    List<Article> listProblemByWord(String word);

}
