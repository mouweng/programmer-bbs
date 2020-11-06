package com.mouweng.bbs.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String uid;

    private Integer roleId;

    private String username;

    private String password;

    private String avatar;

    private Date loginDate;

    private Date gmtCreate;
}
