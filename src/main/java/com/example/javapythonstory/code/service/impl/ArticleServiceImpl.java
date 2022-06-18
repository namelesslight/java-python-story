package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Article;
import com.example.javapythonstory.code.mapper.ArticleMapper;
import com.example.javapythonstory.code.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * <p>
     *     修改文章
     * </p>
     * @param modelId 模块编号
     * @param articleName 文章名
     * @param articleTitle 文章标题
     * @param articleContent 文章内容
     * @return
     */
    @Override
    public Integer addArticle(Integer modelId, String articleName, String articleTitle, String articleContent) {
        Integer addCode = articleMapper.addArticle(modelId, articleName, articleTitle, articleContent);
        return addCode;
    }

    @Override
    public Integer addProblem(String articleTitle, String articleName, String articleContent) {
        Integer addCode = articleMapper.addProblem(articleTitle, articleName, articleContent);
        return addCode;
    }

    /**
     * <p>
     *     修改文章
     * </p>
     * @param articleId 文章编号
     * @param articleTitle 文章标题
     * @param articleContent 文章内容
     * @return
     */
    @Override
    public Integer updateArticle(Integer articleId, String articleTitle, String articleContent) {
        Integer updateCode = articleMapper.updateArticle(articleId, articleTitle, articleContent);
        return updateCode;
    }

    /**
     * <p>
     *     删除文章
     * </p>
     * @param articleId 文章编号
     * @return
     */
    @Override
    public Integer deleteArticle(Integer articleId) {
        Integer deleteCode = articleMapper.deleteArticle(articleId);
        return deleteCode;
    }

    /**
     * <p>
     *     通过模块获取文章
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @Override
    public List<Article> listArticleByModel(Integer modelId) {
        List<Article> data = articleMapper.listArticleByModel(modelId);
        return data;
    }

    /**
     * <p>
     *     通过编号获取文章
     * </p>
     * @param articleId 文章编号
     * @return
     */
    @Override
    public Article queryOneArticleById(Integer articleId) {
        Article data = articleMapper.queryOneArticleById(articleId);
        return data;
    }

    /**
     * <p>
     *     获取问题解决方案
     * </p>
     * @return
     */
    @Override
    public List<Article> listProblem() {
        List<Article> data = articleMapper.listProblem();
        return data;
    }

    /**
     * <p>
     *     通过关键字获取问题解决方案
     * </p>
     * @param word
     * @return
     */
    @Override
    public List<Article> listProblemByWord(String word) {
        List<Article> data = articleMapper.listProblemByWord(word);
        return data;
    }

    /**
     * <p>
     *     获取随机六个文章
     * </p>
     * @return
     */
    @Override
    public List<Article> listArticleByRand() {
        List<Article> data = articleMapper.listArticleByRand();
        return data;
    }

}
