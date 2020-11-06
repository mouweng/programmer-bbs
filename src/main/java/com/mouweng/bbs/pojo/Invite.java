package com.mouweng.bbs.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Invite {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String code;

    private String uid;

    private Integer status;

    private Date activeTime;

    private Date gmtCreate;
}
