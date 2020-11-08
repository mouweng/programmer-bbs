package com.mouweng.bbs.mapper;

import com.mouweng.bbs.pojo.Say;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SayMapper {

    @Select("select * from ks_say order by gmt_create desc")
    List<Say> selectAll();


    @Insert("Insert into ks_say(id, title, content, gmt_create) values(#{id},#{title},#{content},#{gmtCreate})")
    void save(Say say);
}
