package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Article;
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
public interface ArticleMapper extends BaseMapper<Article> {

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
     *     获取单个文章信息
     * </p>
     * @param articleId 模块编号
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
     *     通过关键字获取问题解决方案
     * </p>
     * @param word
     * @return
     */
    List<Article> listProblemByWord(String word);

    /**
     * <p>
     *     获取随机六个文章
     * </p>
     * @return
     */
    List<Article> listArticleByRand();

}
