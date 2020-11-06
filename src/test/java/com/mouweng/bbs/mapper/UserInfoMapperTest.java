package com.mouweng.bbs.mapper;


import com.mouweng.bbs.pojo.Invite;
import com.mouweng.bbs.pojo.User;
import com.mouweng.bbs.pojo.UserInfo;
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
public class UserInfoMapperTest {
    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserMapper userMapper;

    @Test
    @Rollback
    public void test1() throws Exception {
        User user = userMapper.getOne("kunkun");
        userInfoMapper.save(new UserInfo().setUid(user.getUid()));
    }
}
