package com.mouweng.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.mapper.QuestionMapper;
import com.mouweng.bbs.pojo.Question;
import com.mouweng.bbs.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Override
    public int count(String uid) {
        return questionMapper.count(uid);
    }

    @Override
    public PageInfo pageById(int pageNum, int pageSize, String uid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Question> questionList = questionMapper.selectById(uid);
        PageInfo<Question> pageInfo = new PageInfo<>(questionList);
        return pageInfo;
    }
}
