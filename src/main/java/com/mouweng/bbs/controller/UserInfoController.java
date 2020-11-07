package com.mouweng.bbs.controller;

import com.mouweng.bbs.pojo.UserInfo;
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

    @GetMapping("userinfo/setting/{uid}")
    public String userSetting(@PathVariable String uid, Model model) {
        UserInfo userInfo = userInfoService.getById(uid);
        model.addAttribute("userInfo",userInfo);
        if (userInfo.getHobby()!=null && !userInfo.getHobby().equals("")){
            String[] hobbys = userInfo.getHobby().split(",");
            model.addAttribute("infoHobbys",hobbys);
        }
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
