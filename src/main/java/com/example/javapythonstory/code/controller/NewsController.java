package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.entity.dto.news.AddNewsDto;
import com.example.javapythonstory.code.entity.dto.news.DeleteNewsDto;
import com.example.javapythonstory.code.entity.dto.news.UpdateNewsDto;
import com.example.javapythonstory.code.entity.po.News;
import com.example.javapythonstory.code.result.Result;
import com.example.javapythonstory.code.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 
 * @since 2022-06-18
 */
@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    /**
     * <p>
     *     添加新闻
     * </p>
     * @param addNewsDto 添加新闻DTO
     * @return
     */
        @PostMapping("/super/addNews")
    public Result addNews(@RequestBody AddNewsDto addNewsDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = newsService.addNews(
                addNewsDto.getTitle(),
                addNewsDto.getContent());
        message.put("addCode", addCode);
        return new Result().result200(message, "/super/addNews");
    }

    /**
     * <p>
     *     修改新闻
     * </p>
     * @param updateNewsDto 修改新闻DTO
     * @return
     */
    @PostMapping("/super/updateNews")
    public Result updateNews(@RequestBody UpdateNewsDto updateNewsDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = newsService.updateNews(
                updateNewsDto.getNewsId(),
                updateNewsDto.getTitle(),
                updateNewsDto.getContent());
        message.put("updateCode", updateCode);
        return new Result().result200(message, "/super/updateNews");
    }

    /**
     * <p>
     *     删除新闻
     * </p>
     * @param deleteNewsDto 删除新闻DTO
     * @return
     */
    @PostMapping("/super/deleteNews")
    public Result deleteNews(@RequestBody DeleteNewsDto deleteNewsDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = newsService.deleteNews(deleteNewsDto.getNewsId());
        message.put("deleteCode", deleteCode);
        return new Result().result200(message, "/super/deleteNews");
    }

    /**
     * <p>
     *     获取全部新闻
     * </p>
     * @return
     */
    @GetMapping("/common/listNewsByAll")
    public Result listNewsByAll(){
        Map<String, Object> message = new HashMap<>();
        List<News> data = newsService.listNewsByAll();
        message.put("data", data);
        return new Result().result200(message, "/common/listNewsByAll");
    }

    /**
     * <p>
     *     随机获取新闻
     * </p>
     * @return
     */
    @GetMapping("/common/listNewsByRand")
    public Result listNewsByRand(){
        Map<String, Object> message = new HashMap<>();
        List<News> data = newsService.listNewsByRand();
        message.put("data", data);
        return new Result().result200(message, "/common/listNewsByRand");
    }

    /**
     * <p>
     *     根据笔记编号获取笔记
     * </p>
     * @param newsId 新闻编号
     * @return
     */
    @GetMapping("/common/queryOneNewsById")
    public Result queryOneNewsById(@RequestParam Integer newsId){
        Map<String, Object> message = new HashMap<>();
        News data = newsService.queryOneNoteById(newsId);
        message.put("data", data);
        return new Result().result200(message, "/common/queryOneNewsById");
    }

}
