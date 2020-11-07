package com.mouweng.bbs.service;

import com.mouweng.bbs.pojo.Invite;
import com.mouweng.bbs.pojo.User;

public interface InviteService {
    Invite getOne(String code);

    void updateById(Invite invite);
}
