package com.mouweng.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.mapper.DownloadMapper;
import com.mouweng.bbs.pojo.Download;
import com.mouweng.bbs.service.DownloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownloadServiceImpl implements DownloadService {

    @Autowired
    DownloadMapper downloadMapper;

    @Override
    public List<Download> selectAll() {
        return downloadMapper.selectAll();
    }

    @Override
    public PageInfo findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Download> DownloadList = downloadMapper.selectAll();
        PageInfo<Download> pageInfo = new PageInfo<>(DownloadList);
        return pageInfo;
    }
}
