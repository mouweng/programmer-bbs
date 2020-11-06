package com.mouweng.bbs.controller;


import com.mouweng.bbs.pojo.Invite;
import com.mouweng.bbs.pojo.User;
import com.mouweng.bbs.pojo.UserInfo;
import com.mouweng.bbs.service.InviteService;
import com.mouweng.bbs.service.UserInfoService;
import com.mouweng.bbs.service.UserService;
import com.mouweng.bbs.utils.PrintUtils;
import com.mouweng.bbs.utils.TimestampUtils;
import com.mouweng.bbs.utils.UUIDUtils;
import com.mouweng.bbs.vo.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private InviteService inviteService;

    @Autowired
    private UserInfoService userInfoService;



    @GetMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/register")
    public String toRegister(){
        return "register";
    }


    @PostMapping("/register")
    public String register(RegisterForm registerForm, Model model) {
        PrintUtils.print("注册表单信息："+registerForm.toString());
        // 判断两次密码是否重复
        if (!registerForm.getPassword().equals(registerForm.getRepassword())) {
            model.addAttribute("registerMsg", "两次密码不一致");
            return "register";
        }

        // 用户名已存在
        User hasUser = userService.getOne(registerForm.getUsername());
        if (hasUser != null) {
            model.addAttribute("registerMsg", "用户名已经存在");
            return "register";
        }



        Invite invite = inviteService.getOne(registerForm.getCode());
        // 验证邀请码是否存在
        if(invite == null) {
            model.addAttribute("registerMsg","邀请码不存在");
            return "register";
        }
        // 验证邀请码是否有效
        if(invite.getStatus() == 1) {
            model.addAttribute("registerMsg","邀请码已被使用");
            return "register";
        }

        // 构建用户对象
        User user = new User();
        user.setUid(UUIDUtils.getUuid());
        user.setRoleId(2);
        user.setUsername(registerForm.getUsername());
        // 密码加密
        String bCryptPassword = new BCryptPasswordEncoder().encode(registerForm.getPassword());
        user.setPassword(bCryptPassword);
        user.setGmtCreate(TimestampUtils.getTime());
        user.setLoginDate(TimestampUtils.getTime());
        // 保存对象！
        userService.save(user);
        PrintUtils.print("新用户注册成功：" + user);

        // 激活邀请码
        invite.setActiveTime(TimestampUtils.getTime());
        invite.setStatus(1);
        invite.setUid(user.getUid());
        inviteService.updateById(invite);

        // todo: 用户信息
        userInfoService.save(new UserInfo().setUid(user.getUid()));
        // 注册成功，重定向到登录页面
        return "redirect:/toLogin";
    }

}
