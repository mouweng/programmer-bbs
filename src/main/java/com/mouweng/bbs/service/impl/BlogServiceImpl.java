package com.mouweng.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.mapper.BlogMapper;
import com.mouweng.bbs.pojo.Blog;
import com.mouweng.bbs.pojo.Say;
import com.mouweng.bbs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogMapper blogMapper;

    @Override
    public PageInfo page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogList = blogMapper.selectAll();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public PageInfo pageByCategory(int pageNum, int pageSize, int bid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogList = blogMapper.selectByCategory(bid);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public void save(Blog blog) {
        blogMapper.save(blog);
    }

    @Override
    public Blog getOne(String bid) {
        return blogMapper.getOne(bid);
    }

    @Override
    public void updateById(Blog blog) {
        blogMapper.updateById(blog);
    }

    @Override
    public void removeById(Blog blog) {
        blogMapper.removeById(blog.getId());
    }

    @Override
    public int count(String uid) {
        return blogMapper.count(uid);
    }

    @Override
    public PageInfo pageById(int pageNum, int pageSize, String uid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogList = blogMapper.selectById(uid);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }
}
