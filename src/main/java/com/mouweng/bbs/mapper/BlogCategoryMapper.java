package com.mouweng.bbs.mapper;

import com.mouweng.bbs.pojo.BlogCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogCategoryMapper {

    @Select("select * from ks_blog_category")
    List<BlogCategory> list();


    @Select("select * from ks_blog_category where id = #{bid}")
    BlogCategory getById(@Param("bid") int bid);
}
