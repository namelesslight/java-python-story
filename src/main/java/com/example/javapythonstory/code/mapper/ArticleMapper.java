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
 * @author 
 * @since 2022-06-08
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    public Integer addArticle(Integer modelId, String articleName, String articleTitle, String articleContent);

    public Integer updateArticle(Integer articleId, String articleTitle, String articleContent);

    public Integer deleteArticle(Integer articleId);

    public List<Article> listArticleByModel(Integer modelId);

    public Article queryOneArticleById(Integer articleId);

}
