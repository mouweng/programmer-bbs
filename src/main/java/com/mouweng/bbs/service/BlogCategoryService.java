package com.mouweng.bbs.service;

import com.mouweng.bbs.pojo.BlogCategory;

import java.util.List;

public interface BlogCategoryService {

    List<BlogCategory> list();

    BlogCategory getById(int bid);
}
