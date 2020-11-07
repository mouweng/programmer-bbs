package com.mouweng.bbs.service;

import com.mouweng.bbs.pojo.User;

public interface UserService {

    /**
     * 根据姓名查询用户
     * @param username 用户的姓名
     * @return 返回一个用户
     */
    User getOne(String username);

    void save(User user);
}
