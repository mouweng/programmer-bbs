package com.mouweng.bbs.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Blog对象", description="")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Integer id;

    @ApiModelProperty(value = "博客id")
    private String bid;

    @ApiModelProperty(value = "博客标题")
    private String title;

    @ApiModelProperty(value = "博客内容")
    private String content;

    @ApiModelProperty(value = "排序 0 普通  1 置顶")
    private Integer sort;

    @ApiModelProperty(value = "浏览量")
    private Integer views;

    @ApiModelProperty(value = "作者id")
    private String authorId;

    @ApiModelProperty(value = "作者名")
    private String authorName;

    @ApiModelProperty(value = "作者头像")
    private String authorAvatar;

    @ApiModelProperty(value = "问题分类id")
    private Integer categoryId;

    @ApiModelProperty(value = "问题分类名称")
    private String categoryName;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private Date gmtUpdate;
}
