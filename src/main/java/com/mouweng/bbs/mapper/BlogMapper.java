package com.mouweng.bbs.mapper;


import com.mouweng.bbs.pojo.Blog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogMapper {
    @Select("select * from ks_blog order by gmt_update desc")
    List<Blog> selectAll();


    @Select("select * from ks_blog where category_id = #{categoryId} order by gmt_update desc")
    List<Blog> selectByCategory(@Param("categoryId") int categoryId);


    @Insert("Insert into ks_blog(bid, title, content, sort, views, author_id, author_name, author_avatar, category_id, category_name, gmt_create, gmt_update) values(#{bid},#{title},#{content},#{sort},#{views},#{authorId},#{authorName},#{authorAvatar},#{categoryId},#{categoryName},#{gmtCreate},#{gmtUpdate})")
    void save(Blog blog);

    @Select("Select * from ks_blog where bid = #{bid}")
    Blog getOne(String bid);

    @Update("Update ks_blog set views=#{views},title=#{title},category_id=#{categoryId},content=#{content},gmt_update=#{gmtUpdate}  where bid=#{bid}")
    void updateById(Blog blog);


    @Delete("Delete from ks_blog where id = #{id}")
    void removeById(@Param("id") Integer id);

    @Select("select count(*) from ks_blog where author_id = #{uid}")
    int count(@Param("uid") String uid);

    @Select("select * from ks_blog where author_id = #{uid} order by gmt_update desc")
    List<Blog> selectById(@Param("uid") String uid);
}
