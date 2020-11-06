package com.mouweng.bbs.mapper;
import com.mouweng.bbs.pojo.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {

    @Select("select * from ks_user where username = #{username}")
    User getOne(@Param("username") String username);

    @Insert("insert into ks_user(uid, role_id, username, password, login_date, gmt_create) values(#{uid}, #{roleId}, #{username}, #{password}, #{loginDate}, #{gmtCreate})")
    void save(User user);
}
