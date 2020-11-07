package com.mouweng.bbs.service;

import com.mouweng.bbs.pojo.UserInfo;

public interface UserInfoService {

    void save(UserInfo userInfo);


    UserInfo getById(String uid);

    void updateById(UserInfo userInfo);
}
