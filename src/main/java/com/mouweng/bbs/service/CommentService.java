package com.mouweng.bbs.service;

import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> selectByTopicId(String bid);

    void save(Comment comment);

    int count(String uid);

    PageInfo pageById(int pageNum, int pageSize, String uid);

    Comment getOne(String cid);

    void remove(String cid);
}
