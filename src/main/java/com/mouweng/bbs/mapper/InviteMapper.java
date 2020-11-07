package com.mouweng.bbs.mapper;

import com.mouweng.bbs.pojo.Invite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InviteMapper {

    @Select("select * from ks_invite where code = #{code}")
    Invite getOne(@Param("code") String code);


    @Update("update ks_invite set uid = #{uid}, status = #{status}, active_time = #{activeTime} where code = #{code}")
    void updateById(Invite invite);

}
