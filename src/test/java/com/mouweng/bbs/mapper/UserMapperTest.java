package com.mouweng.bbs.mapper;


import com.mouweng.bbs.pojo.User;
import com.mouweng.bbs.utils.TimestampUtils;
import com.mouweng.bbs.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void test() throws Exception {
        User u = userMapper.getOne("mouweng");
        System.out.println(u);
        Assert.assertEquals("mouweng", u.getUsername());
    }

    @Test
    @Rollback
    public void test2() throws Exception {
        // 构建用户对象
        User user = new User();
        user.setUid(UUIDUtils.getUuid());
        user.setRoleId(2);
        user.setUsername("kunkun");
        // 密码加密
        String bCryptPassword = new BCryptPasswordEncoder().encode("123");
        user.setPassword(bCryptPassword);
        user.setGmtCreate(TimestampUtils.getTime());
        user.setLoginDate(TimestampUtils.getTime());

        userMapper.save(user);
    }
}
