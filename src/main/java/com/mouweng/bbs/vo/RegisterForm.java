package com.mouweng.bbs.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true) // 加了这个之后setter方法会访问当前对象
public class RegisterForm {

    private String username;

    private String password;

    private String repassword;

    private String code;
}
