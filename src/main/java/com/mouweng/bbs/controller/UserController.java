package com.mouweng.bbs.controller;

import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.pojo.Blog;
import com.mouweng.bbs.pojo.Comment;
import com.mouweng.bbs.pojo.Question;
import com.mouweng.bbs.pojo.UserInfo;
import com.mouweng.bbs.service.BlogService;
import com.mouweng.bbs.service.CommentService;
import com.mouweng.bbs.service.QuestionService;
import com.mouweng.bbs.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    BlogService blogService;
    @Autowired
    QuestionService questionService;
    @Autowired
    CommentService commentService;


    // 用户信息回填
    private void userInfoCallBack(String uid,Model model){
        UserInfo userInfo = userInfoService.getById(uid);
        model.addAttribute("userInfo",userInfo);
        if (userInfo.getHobby()!=null && !userInfo.getHobby().equals("")){
            String[] hobbys = userInfo.getHobby().split(",");
            model.addAttribute("infoHobbys",hobbys);
        }
        // 获取用户的问题，博客，回复数
        int blogCount = blogService.count(uid);
        int questionCount = questionService.count(uid);
        int commentCount = commentService.count(uid);
        model.addAttribute("blogCount",blogCount);
        model.addAttribute("questionCount",questionCount);
        model.addAttribute("commentCount",commentCount);
    }


    // 更新头像
    @GetMapping("/user/update-avatar/{uid}")
    public String toUpdateAvatar(@PathVariable String uid, Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);
        return "user/update-avatar";
    }

    @GetMapping("/user/{uid}")
    public String userIndex(@PathVariable String uid, Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);
        // 用户的博客列表
        int pageNum = 1;
        int pageSize = 10;

        PageInfo pageParam = blogService.pageById(pageNum, pageSize, uid);
        List<Blog> blogList = pageParam.getList();

        model.addAttribute("blogList",blogList);
        model.addAttribute("pageParam",pageParam);

        return "user/index";
    }

    @GetMapping("/user/blog/{uid}/{pageNum}/{pageSize}")
    public String userIndexBlog(@PathVariable String uid, @PathVariable int pageNum, @PathVariable int pageSize, Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);
        // 用户的博客列表
        if (pageNum < 1){
            pageNum = 1;
        }
        PageInfo pageParam = blogService.pageById(pageNum, pageSize, uid);
        List<Blog> blogList = pageParam.getList();

        model.addAttribute("blogList",blogList);
        model.addAttribute("pageParam",pageParam);

        return "user/index";
    }



    @GetMapping("/user/comment/{uid}/{pageNum}/{pageSize}")
    public String userIndexComment(@PathVariable String uid, @PathVariable int pageNum, @PathVariable int pageSize, Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);
        //
        if (pageNum < 1){
            pageNum = 1;
        }

        PageInfo pageParam = commentService.pageById(pageNum, pageSize, uid);

        // 结果
        List<Comment> commentList = pageParam.getList();
        model.addAttribute("commentList",commentList);
        model.addAttribute("pageParam",pageParam);

        return "user/user-comment";
    }



    @GetMapping("/user/question/{uid}/{pageNum}/{pageSize}")
    public String userIndexQuestion(@PathVariable String uid, @PathVariable int pageNum, @PathVariable int pageSize, Model model){
        // 用户信息回填
        userInfoCallBack(uid,model);

        if (pageNum < 1){
            pageNum = 1;
        }

        PageInfo pageParam = questionService.pageById(pageNum, pageSize, uid);

        // 结果
        List<Question> questionList = pageParam.getList();
        model.addAttribute("questionList",questionList);
        model.addAttribute("pageParam",pageParam);

        return "user/user-question";
    }


}
