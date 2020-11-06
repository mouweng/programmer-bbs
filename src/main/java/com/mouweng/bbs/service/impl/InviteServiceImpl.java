package com.mouweng.bbs.service.impl;

import com.mouweng.bbs.mapper.InviteMapper;
import com.mouweng.bbs.pojo.Invite;
import com.mouweng.bbs.service.InviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InviteServiceImpl implements InviteService {

    @Autowired
    InviteMapper inviteMapper;


    @Override
    public Invite getOne(String code) {
        return inviteMapper.getOne(code);
    }

    @Override
    public void updateById(Invite invite) {
        inviteMapper.updateById(invite);
    }
}
