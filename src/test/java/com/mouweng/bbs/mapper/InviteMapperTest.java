package com.mouweng.bbs.mapper;

import com.mouweng.bbs.pojo.Invite;
import com.mouweng.bbs.pojo.User;
import com.mouweng.bbs.utils.TimestampUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class InviteMapperTest {

    @Autowired
    private InviteMapper inviteMapper;

    @Test
    @Rollback
    public void test1() throws Exception {
        Invite invite = inviteMapper.getOne("1234");
        System.out.println(invite);
        Assert.assertEquals("1234", invite.getCode());
    }

    @Test
    @Rollback
    public void test2() throws Exception {
        Invite invite = inviteMapper.getOne("1234");
        invite.setActiveTime(TimestampUtils.getTime());
        invite.setStatus(0);
        inviteMapper.updateById(invite);
    }


}
