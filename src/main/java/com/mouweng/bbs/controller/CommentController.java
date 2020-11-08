package com.mouweng.bbs.controller;

import com.mouweng.bbs.pojo.Comment;
import com.mouweng.bbs.service.CommentService;
import com.mouweng.bbs.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    // 删除评论
    @GetMapping("/user/comment/delete/{uid}/{cid}")
    public String deleteComment(@PathVariable String uid, @PathVariable String cid){
        Comment comment = commentService.getOne(cid);
        if(!comment.getUserId().equals(uid)) {
            PrintUtils.print("禁止非法删除");
            return "redirect:/error/404";
        }
        commentService.remove(cid);
        return "redirect:/user/comment/"+uid+"/1/10";
    }
}
