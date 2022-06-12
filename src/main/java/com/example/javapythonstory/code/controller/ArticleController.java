package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.article.AddArticleDto;
import com.example.javapythonstory.code.entity.dto.article.DeleteArticleDto;
import com.example.javapythonstory.code.entity.dto.article.UpdateArticleDto;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
        return null;
    }

    @PostMapping("/super/updateArticle")
    public WebResult updateArticle(@RequestBody UpdateArticleDto updateArticleDto){
        return null;
    }

    @PostMapping("/super/AddArticle")
    public WebResult deleteArticle(@RequestBody DeleteArticleDto deleteArticleDto){
        return null;
    }

    @GetMapping("/common/listArticleByModel")
    public WebResult listArticleByModel(@RequestParam Integer modelId){
        return null;
    }

    @GetMapping("/common/queryOneArticleById")
    public WebResult queryOneArticleById(@RequestParam Integer articleId){
        return null;
    }


}
