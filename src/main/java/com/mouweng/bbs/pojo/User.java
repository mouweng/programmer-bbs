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
@ApiModel(value="User对象", description="")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Integer id;

    @ApiModelProperty(value = "用户编号")
    private String uid;

    @ApiModelProperty(value = "角色编号")
    private Integer roleId;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "登录时间")
    private Date loginDate;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;
}
