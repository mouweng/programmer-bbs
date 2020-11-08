package com.mouweng.bbs.controller;

import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.pojo.Blog;
import com.mouweng.bbs.pojo.BlogCategory;
import com.mouweng.bbs.service.BlogCategoryService;
import com.mouweng.bbs.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BlogCategoryController {

    @Autowired
    BlogCategoryService blogCategoryService;
    @Autowired
    BlogService blogService;


    @GetMapping("/blog/category/{bid}/{pageNum}/{pageSize}")
    public String blogPage(@PathVariable int bid, @PathVariable int pageNum, @PathVariable int pageSize, Model model){

        if (pageNum < 1){
            pageNum = 1;
        }

        // 查询这个分类下的所有问题，获取查询的数据信息

        PageInfo pageParam = blogService.pageByCategory(pageNum, pageSize, bid);

        List<Blog> records = pageParam.getList();

        model.addAttribute("blogList",records);
        model.addAttribute("pageParam",pageParam);

        // 查询这个分类信息
        BlogCategory category = blogCategoryService.getById(bid);
        model.addAttribute("thisCategoryName",category.getCategory());

        // 全部分类信息
        List<BlogCategory> categoryList = blogCategoryService.list();
        model.addAttribute("categoryList",categoryList);

        return "blog/list";
    }


}
