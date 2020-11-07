package com.mouweng.bbs.mapper;

import com.mouweng.bbs.pojo.User;
import com.mouweng.bbs.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRoleMapper {

    @Select("select * from ks_user_role where id = #{roleId}")
    UserRole getById(@Param("roleId") Integer roleId);
}
