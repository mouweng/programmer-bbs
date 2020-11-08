package com.mouweng.bbs.service;

import com.github.pagehelper.PageInfo;

public interface QuestionService {
    int count(String uid);

    PageInfo pageById(int pageNum, int pageSize, String uid);
}
