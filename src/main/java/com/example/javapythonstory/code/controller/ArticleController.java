package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.article.AddArticleDto;
import com.example.javapythonstory.code.entity.dto.article.AddProblemDto;
import com.example.javapythonstory.code.entity.dto.article.DeleteArticleDto;
import com.example.javapythonstory.code.entity.dto.article.UpdateArticleDto;
import com.example.javapythonstory.code.entity.po.Article;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author ZCL
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * <p>
     *     添加文章
     * </p>
     * @param addArticleDto 添加文章DTO
     * @return
     */
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

    @PostMapping("/super/addProblem")
    public WebResult addProblem(@RequestBody AddProblemDto addProblemDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = articleService.addProblem(
                addProblemDto.getArticleTitle(),
                addProblemDto.getArticleName(),
                addProblemDto.getArticleContent());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/addProblem");
    }

    /**
     * <p>
     *     修改文章
     * </p>
     * @param updateArticleDto 修改文章DTO
     * @return
     */
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

    /**
     * <p>
     *     删除文章
     * </p>
     * @param deleteArticleDto 删除文章DTO
     * @return
     */
    @PostMapping("/super/deleteArticle")
    public WebResult deleteArticle(@RequestBody DeleteArticleDto deleteArticleDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = articleService.deleteArticle(deleteArticleDto.getArticleId());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/super/deleteArticle");
    }

    /**
     * <p>
     *     通过模块获取文章
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @GetMapping("/common/listArticleByModel")
    public WebResult listArticleByModel(@RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<Article> data = articleService.listArticleByModel(modelId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/listArticleByModel");
    }

    /**
     * <p>
     *     通过编号获取文章
     * </p>
     * @param articleId 文章编号
     * @return
     */
    @GetMapping("/common/queryOneArticleById")
        public WebResult queryOneArticleById(@RequestParam Integer articleId){
        Map<String, Object> message = new HashMap<>();
        Article data = articleService.queryOneArticleById(articleId);
        message.put("data", data);
        return new WebResult().result200(message, "/common/queryOneArticleById");
    }

    /**
     * <p>
     *     查询问题解决方法
     * </p>
     * @return
     */
    @GetMapping("/common/listProblem")
    public WebResult listProblem(){
        Map<String, Object> message = new HashMap<>();
        List<Article> data = articleService.listProblem();
        message.put("data", data);
        return new WebResult().result200(message, "/common/listProblem");
    }

    /**
     * <p>
     *     通过关键词查询问题解决方法
     * </p>
     * @param word 关键词
     * @return
     */
    @GetMapping("/common/listProblemByWord")
    public WebResult listProblemByWord(@RequestParam String word){
        Map<String, Object> message = new HashMap<>();
        List<Article> data = articleService.listProblemByWord(word);
        message.put("data", data);
        return new WebResult().result200(message, "/common/listProblemByWord");
    }

}
