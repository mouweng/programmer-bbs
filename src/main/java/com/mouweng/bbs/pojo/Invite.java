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
@ApiModel(value="Invite邀请码", description="邀请码")
public class Invite {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增id")
    private Integer id;

    @ApiModelProperty(value = "邀请码")
    private String code;

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "状态 0 未使用 1 使用")
    private Integer status;

    @ApiModelProperty(value = "激活时间")
    private Date activeTime;

    @ApiModelProperty(value = "创建时间")
    private Date gmtCreate;

}
