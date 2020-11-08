package com.mouweng.bbs.controller;

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
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    BlogService blogService;
    @Autowired
    QuestionService questionService;
    @Autowired
    CommentService commentService;

    @GetMapping("userinfo/setting/{uid}")
    public String userSetting(@PathVariable String uid, Model model) {
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

        return "user/settings";
    }

    // 提交更新资料的请求
    @PostMapping("/userinfo/update/{uid}")
    public String userInfo(@PathVariable String uid,UserInfo userInfo){
        // 获取用户信息;
        userInfoService.updateById(userInfo);
        return "redirect:/user/"+uid;
    }


}
