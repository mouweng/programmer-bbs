package com.mouweng.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.mapper.SayMapper;
import com.mouweng.bbs.pojo.Say;
import com.mouweng.bbs.service.SayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SayServiceImpl implements SayService {
    @Autowired
    SayMapper sayMapper;


    @Override
    public PageInfo page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Say> sayList = sayMapper.selectAll();
        PageInfo<Say> pageInfo = new PageInfo<>(sayList);
        return pageInfo;
    }

    @Override
    public void save(Say say) {
        sayMapper.save(say);
    }
}
