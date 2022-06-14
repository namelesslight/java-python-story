package com.example.javapythonstory.code.service.impl;

import com.example.javapythonstory.code.entity.po.Question;
import com.example.javapythonstory.code.entity.po.Select;
import com.example.javapythonstory.code.entity.vo.question.QuestionVo;
import com.example.javapythonstory.code.mapper.QuestionMapper;
import com.example.javapythonstory.code.mapper.SelectMapper;
import com.example.javapythonstory.code.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ZCL
 * @since 2022-06-08
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private SelectMapper selectMapper;

    /**
     * <p>
     *     添加练习题
     * </p>
     * @param modelId 模块编号
     * @param content 问题内容
     * @param answer 问题参考答案
     * @return
     */
    @Override
    public Integer addTrainingQuestion(Integer modelId, String content, String answer) {
        Integer addCode = questionMapper.addTrainingQuestion(modelId, content, answer);
        return addCode;
    }

    /**
     * <p>
     *     添加问卷内容
     * </p>
     * @param content 问卷内容
     * @param answer 问卷回答
     * @return
     */
    @Override
    public Integer addAskQuestion(String content, String answer) {
        Integer addCode = questionMapper.addAskQuestion(content, answer);
        return addCode;
    }

    /**
     * <p>
     *     修改问题
     * </p>
     * @param questionId 问题编号
     * @param content 问题内容
     * @param answer 问题参考答案
     * @return
     */
    @Override
    public Integer updateQuestion(Integer questionId, String content, String answer) {
        Integer updateCode = questionMapper.updateQuestion(questionId, content, answer);
        return updateCode;
    }

    /**
     * <p>
     *     删除问题
     * </p>
     * @param questionId 问题编号
     * @return
     */
    @Override
    public Integer deleteQuestion(Integer questionId) {
        Integer deleteCode= questionMapper.deleteQuestion(questionId);
        return deleteCode;
    }

    /**
     * <p>
     *     通过模块获取对应练习题
     * </p>
     * @param modelId 模块编号
     * @return
     */
    @Override
    public List<QuestionVo> listQuestionByModel(Integer modelId) {
        List<QuestionVo> questionInfo = questionMapper.listQuestionByModel(modelId);
        return questionInfo;
    }

    /**
     * <p>
     *     获取问卷问题
     * </p>
     * @return
     */
    @Override
    public List<QuestionVo> listQuestionByAsk() {
        //先获取题目内容
        List<QuestionVo> questionInfo = questionMapper.listQuestionByAsk();
        //根据题目内容获取题目中选项选项
        for (QuestionVo q : questionInfo) {
            Integer questionId = q.getQuestionId();
            List<Select> select = selectMapper.listSelectByQuestionId(questionId);
            q.setSelect(select);
        }
        return questionInfo;
    }

    /**
     * <p>
     *     通过问题编号获取问卷问题
     * </p>
     * @param questionId 问题编号
     * @return
     */
    @Override
    public QuestionVo queryOneQuestionById(Integer questionId) {
        //先获取题目内容
        QuestionVo question = questionMapper.queryOneQuestionById(questionId);
        //根据题目内容获取题目中选项选项
        List<Select> select = selectMapper.listSelectByQuestionId(questionId);
        question.setSelect(select);
        return question;
    }
}
