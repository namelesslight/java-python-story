package com.example.javapythonstory.code.controller;


import com.example.javapythonstory.code.entity.dto.question.AddAskQuestionDto;
import com.example.javapythonstory.code.entity.dto.question.AddTrainingQuestionDto;
import com.example.javapythonstory.code.entity.dto.question.DeleteQuestionDto;
import com.example.javapythonstory.code.entity.dto.question.UpdateQuestionDto;
import com.example.javapythonstory.code.entity.vo.question.QuestionVo;
import com.example.javapythonstory.code.result.WebResult;
import com.example.javapythonstory.code.service.QuestionService;
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
 * @author ZCL
 * @since 2022-06-08
 */
@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * <p>
     *     添加练习题
     * </p>
     * @param addQuestionDto 添加练习题DTO
     * @return
     */
    @PostMapping("/super/addTrainingQuestion")
    public WebResult addTrainingQuestion(@RequestBody AddTrainingQuestionDto addQuestionDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = questionService.addTrainingQuestion(
                addQuestionDto.getModelId(),
                addQuestionDto.getContent(),
                addQuestionDto.getAnswer());
        message.put("addCode",addCode);
        return new WebResult().result200(message, "/super/addQuestion");
    }

    /**
     * <p>
     *     添加问卷内容
     * </p>
     * @param addAskQuestionDto 添加问卷内容DTO
     * @return
     */
    @PostMapping("/super/addAskQuestion")
    public WebResult addAskQuestion(@RequestBody AddAskQuestionDto addAskQuestionDto){
        Map<String, Object> message = new HashMap<>();
        Integer addCode = questionService.addAskQuestion(addAskQuestionDto.getContent(), addAskQuestionDto.getAnswer());
        message.put("addCode", addCode);
        return new WebResult().result200(message, "/super/addQuestion");
    }

    /**
     * <p>
     *     修改问题
     * </p>
     * @param updateQuestionDto 修改问题DTO
     * @return
     */
    @PostMapping("/super/updateQuestion")
    public WebResult updateQuestion(@RequestBody UpdateQuestionDto updateQuestionDto){
        Map<String, Object> message = new HashMap<>();
        Integer updateCode = questionService.updateQuestion(
                updateQuestionDto.getQuestionId(),
                updateQuestionDto.getContent(),
                updateQuestionDto.getAnswer());
        message.put("updateCode", updateCode);
        return new WebResult().result200(message, "/super/updateQuestion");
    }

    /**
     * <p>
     *     删除问题
     * </p>
     * @param deleteQuestionDto 删除问题DTO
     * @return
     */
    @PostMapping("/super/deleteQuestion")
    public WebResult deleteQuestion(@RequestBody DeleteQuestionDto deleteQuestionDto){
        Map<String, Object> message = new HashMap<>();
        Integer deleteCode = questionService.deleteQuestion(deleteQuestionDto.getQuestionId());
        message.put("deleteCode", deleteCode);
        return new WebResult().result200(message, "/super/deleteQuestion");
    }

    /**
     * <p>
     *     通过模块获取对应练习题
     * </p>
     * @param modelId 通过模块获取对应练习题DTO
     * @return
     */
    @GetMapping("/common/listQuestionByModel")
    public WebResult listQuestionByModel(@RequestParam Integer modelId){
        Map<String, Object> message = new HashMap<>();
        List<QuestionVo> questionInfo = questionService.listQuestionByModel(modelId);
        message.put("questionInfo", questionInfo);
        return new WebResult().result200(message, "/common/listQuestionByModel");
    }

    /**
     * <p>
     *     获取问卷问题
     * </p>
     * @return
     */
    @GetMapping("/common/listQuestionByAsk")
    public WebResult listQuestionByAsk(){
        Map<String, Object> message = new HashMap<>();
        List<QuestionVo> questionInfo = questionService.listQuestionByAsk();
        message.put("questionInfo", questionInfo);
        return new WebResult().result200(message, "/common/listQuestionByModel");
    }

    /**
     * <p>
     *     通过问题编号获取问卷问题
     * </p>
     * @param questionId 问题编号
     * @return
     */
    @GetMapping("/common/queryOneQuestionById")
    public WebResult queryOneQuestionById(@RequestParam Integer questionId){
        Map<String, Object> message = new HashMap<>();
        QuestionVo questionInfo = questionService.queryOneQuestionById(questionId);
        message.put("questionInfo", questionInfo);
        return new WebResult().result200(message, "/common/queryOneQuestionById");
    }

}
