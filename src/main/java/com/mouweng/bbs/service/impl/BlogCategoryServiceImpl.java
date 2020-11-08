package com.mouweng.bbs.service.impl;

import com.mouweng.bbs.mapper.BlogCategoryMapper;
import com.mouweng.bbs.pojo.BlogCategory;
import com.mouweng.bbs.service.BlogCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogCategoryServiceImpl implements BlogCategoryService {

    @Autowired
    BlogCategoryMapper blogCategoryMapper;

    @Override
    public List<BlogCategory> list() {
        return blogCategoryMapper.list();
    }

    @Override
    public BlogCategory getById(int bid) {
        return blogCategoryMapper.getById(bid);
    }
}
