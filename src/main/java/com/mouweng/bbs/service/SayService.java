package com.mouweng.bbs.service;

import com.github.pagehelper.PageInfo;
import com.mouweng.bbs.pojo.Say;

public interface SayService {

    PageInfo page(int pageNum, int pageSize);

    void save(Say say);
}
