package com.mouweng.bbs.pojo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String uid;

    private String nickname;

    private String realname;

    private String qq;

    private String wechat;

    private String email;

    private String phone;

    private String work;

    private String address;

    private String hobby;

    private String intro;
}
