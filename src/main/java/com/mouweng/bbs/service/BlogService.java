package com.mouweng.bbs.service;

import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.pojo.Blog;

public interface BlogService {


    PageInfo page(int pageNum, int pageSize);

    PageInfo pageByCategory(int pageNum, int pageSize, int bid);

    PageInfo pageById(int pageNum, int pageSize, String uid);

    void save(Blog blog);

    Blog getOne(String bid);

    void updateById(Blog blog);

    void removeById(Blog blog);

    int count(String uid);

}
