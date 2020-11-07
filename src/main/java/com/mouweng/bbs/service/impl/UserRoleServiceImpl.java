package com.mouweng.bbs.service.impl;

import com.mouweng.bbs.mapper.UserMapper;
import com.mouweng.bbs.mapper.UserRoleMapper;
import com.mouweng.bbs.pojo.UserRole;
import com.mouweng.bbs.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;


    @Override
    public UserRole getById(Integer roleId) {
        return userRoleMapper.getById(roleId);
    }
}
