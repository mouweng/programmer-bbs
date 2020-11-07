package com.mouweng.bbs.mapper;


import com.mouweng.bbs.pojo.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoMapper {


    @Insert("insert into ks_user_info(uid, nickname, realname, qq, wechat, email, phone, work, address, hobby, intro) values(#{uid}, #{nickname}, #{realname}, #{qq}, #{wechat}, #{email}, #{phone}, #{work}, #{address}, #{hobby}, #{intro})")
    void save(UserInfo userInfo);

    @Select("select * from ks_user_info where uid = #{uid}")
    UserInfo getById(@Param("uid") String uid);

    @Update("update ks_user_info set nickname=#{nickname}, realname=#{realname}, qq=#{qq}, wechat=#{wechat}, email=#{email}, phone=#{phone}, work=#{work}, address=#{address}, hobby=#{hobby}, intro=#{intro} where uid = #{uid}")
    void updateById(UserInfo userInfo);
}
