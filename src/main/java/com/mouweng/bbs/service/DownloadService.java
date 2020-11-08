package com.mouweng.bbs.service;

import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.pojo.Download;

import java.util.List;

public interface DownloadService {

    List<Download> selectAll();

    PageInfo findAll(int pageNum, int pageSize);
}
