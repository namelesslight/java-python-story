package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.article.AddArticleDto;
import com.example.javapythonstory.code.entity.dto.article.DeleteArticleDto;
import com.example.javapythonstory.code.entity.dto.article.UpdateArticleDto;
import com.example.javapythonstory.code.entity.po.Article;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PostMapping("/super/addArticle")
    public WebResult addArticle(@RequestBody AddArticleDto addArticleDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = articleService.addArticle(
                addArticleDto.getModelId(),
                addArticleDto.getArticleName(),
                addArticleDto.getArticleTitle(),
                addArticleDto.getArticleContent());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/addArticle");
    }

    @PostMapping("/super/updateArticle")
    public WebResult updateArticle(@RequestBody UpdateArticleDto updateArticleDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = articleService.updateArticle(
                updateArticleDto.getArticleId(),
                updateArticleDto.getArticleTitle(),
                updateArticleDto.getArticleContent());
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/super/updateArticle");
    }

    @PostMapping("/super/deleteArticle")
    public WebResult deleteArticle(@RequestBody DeleteArticleDto deleteArticleDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = articleService.deleteArticle(deleteArticleDto.getArticleId());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/super/deleteArticle");
    }

    @GetMapping("/common/listArticleByModel")
    public WebResult listArticleByModel(@RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Article> data = articleService.listArticleByModel(modelId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/listArticleByModel");
    }

    @GetMapping("/common/queryOneArticleById")
        public WebResult queryOneArticleById(@RequestParam Integer articleId){
        Map<String, Object> message = new HashMap<>();
        Article data = articleService.queryOneArticleById(articleId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/queryOneArticleById");
    }


}
