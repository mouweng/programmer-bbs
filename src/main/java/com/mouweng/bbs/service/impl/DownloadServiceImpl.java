package com.mouweng.bbs.service.impl;

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
}
