package com.mouweng.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.mouweng.bbs.mapper.CommentMapper;
import com.mouweng.bbs.pojo.Comment;
import com.mouweng.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> selectByTopicId(String topic_id) {
        return commentMapper.selectByTopicId(topic_id);
    }

    @Override
    public void save(Comment comment) {
        commentMapper.save(comment);
    }

    @Override
    public int count(String uid) {
        return commentMapper.count(uid);
    }

    @Override
    public PageInfo pageById(int pageNum, int pageSize, String uid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comment> commentList = commentMapper.selectById(uid);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        return pageInfo;
    }

    @Override
    public Comment getOne(String cid) {
        return commentMapper.getOne(cid);
    }

    @Override
    public void remove(String cid) {
        commentMapper.remove(cid);
    }
}
