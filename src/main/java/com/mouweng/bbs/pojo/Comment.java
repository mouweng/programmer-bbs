package com.mouweng.bbs.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Comment对象", description="")

public class Comment {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Integer id;

    @ApiModelProperty(value = "评论唯一id")
    private String commentId;

    @ApiModelProperty(value = "1博客 2问答")
    private Integer topicCategory;

    @ApiModelProperty(value = "评论主题id")
    private String topicId;

    @ApiModelProperty(value = "评论者id")
    private String userId;

    @ApiModelProperty(value = "评论者昵称")
    private String userName;

    @ApiModelProperty(value = "评论者头像")
    private String userAvatar;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "评论创建时间")
    private Date gmtCreate;

}
