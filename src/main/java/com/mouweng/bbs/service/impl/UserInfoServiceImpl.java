package com.mouweng.bbs.service.impl;

import com.mouweng.bbs.mapper.UserInfoMapper;
import com.mouweng.bbs.pojo.UserInfo;
import com.mouweng.bbs.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public void save(UserInfo userInfo) {
        userInfoMapper.save(userInfo);
    }
}
