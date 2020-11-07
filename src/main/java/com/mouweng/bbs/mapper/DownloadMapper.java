package com.mouweng.bbs.mapper;


import com.mouweng.bbs.pojo.Download;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DownloadMapper {

    @Select("select * from ks_download")
    List<Download> selectAll();
}
