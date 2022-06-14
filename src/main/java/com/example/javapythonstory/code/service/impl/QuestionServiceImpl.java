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
 * @author 
 * @since 2022-06-08
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private SelectMapper selectMapper;

    @Override
    public Integer addTrainingQuestion(Integer modelId, String content, String answer) {
        Integer addCode = questionMapper.addTrainingQuestion(modelId, content, answer);
        return addCode;
    }

    @Override
    public Integer addAskQuestion(String content, String answer) {
        Integer addCode = questionMapper.addAskQuestion(content, answer);
        return addCode;
    }

    @Override
    public Integer updateQuestion(Integer questionId, String content, String answer) {
        Integer updateCode = questionMapper.updateQuestion(questionId, content, answer);
        return updateCode;
    }

    @Override
    public Integer deleteQuestion(Integer questionId) {
        Integer deleteCode= questionMapper.deleteQuestion(questionId);
        return deleteCode;
    }

    @Override
    public List<QuestionVo> listQuestionByModel(Integer modelId) {
        List<QuestionVo> questionInfo = questionMapper.listQuestionByModel(modelId);
        return questionInfo;
    }

    @Override
    public List<QuestionVo> listQuestionByAsk() {
        List<QuestionVo> questionInfo = questionMapper.listQuestionByAsk();
        for (QuestionVo q : questionInfo) {
            Integer questionId = q.getQuestionId();
            List<Select> select = selectMapper.listSelectByQuestionId(questionId);
            q.setSelect(select);
        }
        return questionInfo;
    }

    @Override
    public QuestionVo queryOneQuestionById(Integer questionId) {
        QuestionVo question = questionMapper.queryOneQuestionById(questionId);
        List<Select> select = selectMapper.listSelectByQuestionId(questionId);
        question.setSelect(select);
        return question;
    }
}
