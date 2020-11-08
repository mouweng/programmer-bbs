package com.mouweng.bbs.controller;

import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.pojo.Blog;
import com.mouweng.bbs.pojo.BlogCategory;
import com.mouweng.bbs.pojo.Comment;
import com.mouweng.bbs.service.BlogCategoryService;
import com.mouweng.bbs.service.BlogService;
import com.mouweng.bbs.service.CommentService;
import com.mouweng.bbs.utils.PrintUtils;
import com.mouweng.bbs.utils.TimestampUtils;
import com.mouweng.bbs.utils.UUIDUtils;
import com.mouweng.bbs.vo.QuestionWriteForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    BlogCategoryService blogCategoryService;

    @Autowired
    CommentService commentService;

    @GetMapping("/blog")
    public String blogList(Model model) {

        int pageNum = 1;
        int pageSize = 10;

        PageInfo pageParam = blogService.page(pageNum, pageSize);
        List<Blog> blogList = pageParam.getList();

        model.addAttribute("blogList",blogList);
        model.addAttribute("pageParam",pageParam);

        // 分类信息
        List<BlogCategory> categoryList = blogCategoryService.list();
        model.addAttribute("categoryList",categoryList);

        return "blog/list";
    }


    // todo:这个地方写的冗余了，其实可以删减
    @GetMapping("/blog/{pageNum}/{pageSize}")
    public String blogListPage(@PathVariable int pageNum, @PathVariable int pageSize, Model model){

        if (pageNum < 1){
            pageNum = 1;
        }
        PageInfo pageParam = blogService.page(pageNum, pageSize);

        // 结果
        List<Blog> blogList = pageParam.getList();
        model.addAttribute("blogList",blogList);
        model.addAttribute("pageParam",pageParam);

        // 分类信息
        List<BlogCategory> categoryList = blogCategoryService.list();
        model.addAttribute("categoryList",categoryList);

        return "blog/list";
    }

    // 写文章
    @GetMapping("/blog/write")
    public String toWrite(Model model){
        List<BlogCategory> categoryList = blogCategoryService.list();
        model.addAttribute("categoryList",categoryList);
        return "blog/write";
    }


    @PostMapping("/blog/write")
    public synchronized String write(QuestionWriteForm questionWriteForm){
        // 构建问题对象
        Blog blog = new Blog();

        blog.setBid(UUIDUtils.getUuid());
        blog.setTitle(questionWriteForm.getTitle());
        blog.setContent(questionWriteForm.getContent());
        blog.setSort(0);
        blog.setViews(0);

        blog.setAuthorId(questionWriteForm.getAuthorId());
        blog.setAuthorName(questionWriteForm.getAuthorName());
        blog.setAuthorAvatar(questionWriteForm.getAuthorAvatar());

        BlogCategory category = blogCategoryService.getById(questionWriteForm.getCategoryId());
        blog.setCategoryId(questionWriteForm.getCategoryId());
        blog.setCategoryName(category.getCategory());
        blog.setGmtCreate(TimestampUtils.getTime());
        blog.setGmtUpdate(TimestampUtils.getTime());
        // 存储对象
        blogService.save(blog);

        // 重定向到列表页面
        return "redirect:/blog";
    }


    // 阅读文章
    @GetMapping("/blog/read/{bid}")
    public String read(@PathVariable("bid") String bid,Model model){
        Blog blog = blogService.getOne(bid);

        // todo: redis缓存. 防止阅读重复
        blog.setViews(blog.getViews()+1);
        blogService.updateById(blog);
        model.addAttribute("blog",blog);

        // todo： 查询评论
        List<Comment> commentList = commentService.selectByTopicId(bid);
        model.addAttribute("commentList",commentList);
        return "blog/read";
    }

    // 评论
    @PostMapping("/blog/comment/{bid}")
    public String comment(@PathVariable("bid") String bid, Comment comment){
        // 存储评论
        comment.setCommentId(UUIDUtils.getUuid());
        comment.setTopicCategory(1);
        comment.setGmtCreate(TimestampUtils.getTime());
        commentService.save(comment);
        // 重定向到列表页面
        return "redirect:/blog/read/"+bid;
    }

    // 删除博客
    @GetMapping("/blog/delete/{uid}/{bid}")
    public String delete(@PathVariable("uid") String uid, @PathVariable("bid") String bid){

        Blog blog = blogService.getOne(bid);

        if (!blog.getAuthorId().equals(uid)){
            PrintUtils.print("禁止非法删除");
            return "redirect:/blog";
        }

        blogService.removeById(blog);
        // 重定向到列表页面
        return "redirect:/blog";
    }

    // 编辑博客
    @GetMapping("/blog/editor/{uid}/{bid}")
    public synchronized String toEditor(@PathVariable("uid") String uid,
                                        @PathVariable("bid") String bid,Model model){

        Blog blog = blogService.getOne(bid);

        if (!blog.getAuthorId().equals(uid)){
            PrintUtils.print("禁止非法编辑");
            return "redirect:/blog";
        }

        model.addAttribute("blog",blog);

        List<BlogCategory> categoryList = blogCategoryService.list();
        model.addAttribute("categoryList",categoryList);

        return "blog/editor";
    }

    @PostMapping("/blog/editor")
    public String editor(Blog blog){
        Blog queryBlog = blogService.getOne(blog.getBid());

        queryBlog.setTitle(blog.getTitle());
        queryBlog.setCategoryId(blog.getCategoryId());
        queryBlog.setContent(blog.getContent());
        queryBlog.setGmtUpdate(TimestampUtils.getTime());

        blogService.updateById(queryBlog);

        return "redirect:/blog/read/"+blog.getBid();
    }





}
