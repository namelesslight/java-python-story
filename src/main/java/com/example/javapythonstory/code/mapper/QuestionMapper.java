package com.example.javapythonstory.code.mapper;

import com.example.javapythonstory.code.entity.po.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javapythonstory.code.entity.vo.question.QuestionVo;
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
public interface QuestionMapper extends BaseMapper<Question> {

    Integer addTrainingQuestion(Integer modelId, String content,String answer);

    Integer addAskQuestion(String content, String answer);

    Integer updateQuestion(Integer questionId, String content, String answer);

    Integer deleteQuestion(Integer questionId);

    List<QuestionVo> listQuestionByModel(Integer modelId);

    List<QuestionVo> listQuestionByAsk();

    QuestionVo queryOneQuestionById(Integer questionId);

}
