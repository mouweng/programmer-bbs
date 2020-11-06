package com.mouweng.bbs.service.impl;

import com.mouweng.bbs.mapper.UserMapper;
import com.mouweng.bbs.pojo.User;
import com.mouweng.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
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

}
