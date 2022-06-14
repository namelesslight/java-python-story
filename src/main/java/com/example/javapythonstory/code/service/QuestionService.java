package com.example.javapythonstory.code.service;

import com.example.javapythonstory.code.entity.po.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.javapythonstory.code.entity.vo.question.QuestionVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 
 * @since 2022-06-08
 */
public interface QuestionService extends IService<Question> {

    Integer addTrainingQuestion(Integer modelId, String content,String answer);

    Integer addAskQuestion(String content, String answer);

    Integer updateQuestion(Integer questionId, String content, String answer);

    Integer deleteQuestion(Integer questionId);

    List<QuestionVo> listQuestionByModel(Integer modelId);

    List<QuestionVo> listQuestionByAsk();

    QuestionVo queryOneQuestionById(Integer questionId);

}
