package com.mouweng.bbs.service.impl;

import com.mouweng.bbs.mapper.UserMapper;
import com.mouweng.bbs.pojo.User;
import com.mouweng.bbs.pojo.UserRole;
import com.mouweng.bbs.service.UserRoleService;
import com.mouweng.bbs.service.UserService;
import com.mouweng.bbs.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserMapper userMapper;


    /**
     * 根据姓名查询用户
     * @param username 用户的姓名
     * @return 返回一个用户
     */
    @Override
    public User getOne(String username) {
        return userMapper.getOne(username);
    }


    @Override
    public void save(User user) {
        userMapper.save(user);
    }



    @Autowired
    UserService userService;
    @Autowired
    UserRoleService roleService;
    @Autowired
    HttpSession session;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 通过用户名查询用户
        User user = userService.getOne(s);
        //创建一个新的UserDetails对象，最后验证登陆的需要
        UserDetails userDetails=null;

        if(user != null){
            // 放入session
            session.setAttribute("loginUser",user);

            // 登录后会将登录密码进行加密，然后比对数据库中的密码，数据库密码需要加密存储！
            String password = user.getPassword();

            //创建一个集合来存放权限
            Collection<GrantedAuthority> authorities = getAuthorities(user);

            //实例化UserDetails对象
            userDetails=new org.springframework.security.core.userdetails.User(s,password,
                    true,
                    true,
                    true,
                    true, authorities);
        } else {
            // 这里很重要，不抛出异常的话，在控制台会打印出一堆错误
            throw new UsernameNotFoundException("用户名不存在！");
        }
        return userDetails;
    }

    // 获取角色信息
    private Collection<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        UserRole role = roleService.getById(user.getRoleId());
        //注意：这里每个权限前面都要加ROLE_。否在最后验证不会通过
        authList.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        return authList;
    }

}
