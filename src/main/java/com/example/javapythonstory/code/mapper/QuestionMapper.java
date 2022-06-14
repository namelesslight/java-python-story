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
 * @author ZCL
 * @since 2022-06-08
 */
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * <p>
     *     添加练习题
     * </p>
     * @param modelId 模块编号
     * @param content 问题内容
     * @param answer 问题参考答案
     * @return
     */
    Integer addTrainingQuestion(Integer modelId, String content,String answer);

    /**
     * <p>
     *     添加问卷内容
     * </p>
     * @param content 问卷内容
     * @param answer 问卷回答
     * @return
     */
    Integer addAskQuestion(String content, String answer);

    /**
     * <p>
     *     修改问题
     * </p>
     * @param questionId 问题编号
     * @param content 问题内容
     * @param answer 问题参考答案
     * @return
     */
    Integer updateQuestion(Integer questionId, String content, String answer);

    /**
     * <p>
     *     删除问题
     * </p>
     * @param questionId 问题编号
     * @return
     */
    Integer deleteQuestion(Integer questionId);

    /**
     * <p>
     *     通过模块获取对应练习题
     * </p>
     * @param modelId 模块编号
     * @return
     */
    List<QuestionVo> listQuestionByModel(Integer modelId);

    /**
     * <p>
     *     获取问卷问题
     * </p>
     * @return
     */
    List<QuestionVo> listQuestionByAsk();

    /**
     * <p>
     *     通过问题编号获取问卷问题
     * </p>
     * @param questionId 问题编号
     * @return
     */
    QuestionVo queryOneQuestionById(Integer questionId);

}
