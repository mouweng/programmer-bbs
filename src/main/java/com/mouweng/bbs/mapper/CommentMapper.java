package com.mouweng.bbs.mapper;

import com.mouweng.bbs.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {


    @Select("select * from ks_comment where topic_id = #{topic_id} order by gmt_create desc")
    List<Comment> selectByTopicId(@Param("topic_id") String topic_id);

    @Insert("Insert into ks_comment(comment_id, topic_category, topic_id, user_id, user_name, user_avatar, content, gmt_create) values(#{commentId},#{topicCategory},#{topicId},#{userId},#{userName},#{userAvatar},#{content},#{gmtCreate})")
    void save(Comment comment);

    @Select("select count(*) from ks_comment where user_id = #{uid}")
    int count(@Param("uid") String uid);

    @Select("select * from ks_comment where user_id = #{uid}")
    List<Comment> selectById(@Param("uid") String uid);


    @Select("select * from ks_comment where comment_id = #{cid}")
    Comment getOne(@Param("cid") String cid);

    @Select("delete from ks_comment where comment_id = #{cid}")
    void remove(String cid);
}
