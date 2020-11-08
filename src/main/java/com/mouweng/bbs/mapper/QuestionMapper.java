package com.mouweng.bbs.mapper;

import com.mouweng.bbs.pojo.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {

    @Select("select count(*) from ks_question where author_id = #{uid}")
    int count(String uid);


    @Select("select * from ks_question where author_id = #{uid} order by gmt_update desc")
    List<Question> selectById(String uid);
}
