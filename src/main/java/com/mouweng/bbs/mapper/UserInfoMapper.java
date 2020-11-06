package com.mouweng.bbs.mapper;


import com.mouweng.bbs.pojo.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {


    @Insert("insert into ks_user_info(uid, nickname, realname, qq, wechat, email, phone, work, address, hobby, intro) values(#{uid}, #{nickname}, #{realname}, #{qq}, #{wechat}, #{email}, #{phone}, #{work}, #{address}, #{hobby}, #{intro})")
    void save(UserInfo userInfo);
}
