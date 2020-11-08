package com.mouweng.bbs.mapper;

import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.pojo.Download;
import com.mouweng.bbs.pojo.Invite;
import com.mouweng.bbs.service.DownloadService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DownloadMapperTest {

    @Autowired
    private DownloadMapper downloadMapper;

    @Autowired
    private DownloadService downloadService;

    @Test
    @Rollback
    public void test1() throws Exception {
        List<Download> downloads = downloadMapper.selectAll();
        System.out.println(downloads);
    }

    @Test
    @Rollback
    public void test2() throws Exception {
        PageInfo pageInfo = downloadService.findAll(2,2);
        System.out.print(pageInfo);

    }
}
