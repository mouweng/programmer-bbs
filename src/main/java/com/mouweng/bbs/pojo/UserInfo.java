package com.mouweng.bbs.pojo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="UserInfo对象", description="")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "QQ")
    private String qq;

    @ApiModelProperty(value = "WeChat")
    private String wechat;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机")
    private String phone;

    @ApiModelProperty(value = "工作")
    private String work;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(value = "爱好")
    private String hobby;

    @ApiModelProperty(value = "自我介绍")
    private String intro;
}
