package com.mouweng.bbs.controller;

import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.pojo.Say;
import com.mouweng.bbs.service.SayService;
import com.mouweng.bbs.utils.TimestampUtils;
import com.mouweng.bbs.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SayController {

    @Autowired
    SayService sayService;


    @GetMapping("/say")
    public String userIndexBlog(Model model){
        int pageNum = 1;
        int pageSize = 50;
        PageInfo pageInfo = sayService.page(pageNum, pageSize);
        List<Say> sayList = pageInfo.getList();
        System.out.println(sayList);
        model.addAttribute("sayList",sayList);
        model.addAttribute("pageParam",pageInfo);
        return "page/say";
    }

    @PostMapping("/say/{role}")
    public String saveSay(@PathVariable("role") int role, Say say) {
        // 防止请求提交
        if (role!=1){
            return "redirect:/say";
        }
        say.setId(UUIDUtils.getUuid());
        say.setGmtCreate(TimestampUtils.getTime());
        // 结果
        sayService.save(say);
        return "redirect:/say";
    }

}
