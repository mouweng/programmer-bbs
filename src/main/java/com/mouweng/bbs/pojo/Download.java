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
@ApiModel(value="Download对象", description="")
public class Download implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "资源名")
    private String dname;

    @ApiModelProperty(value = "资源链接")
    private String ddesc;

    @ApiModelProperty(value = "提取码")
    private String dcode;
}
