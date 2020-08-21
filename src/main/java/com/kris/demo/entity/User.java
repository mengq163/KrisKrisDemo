package com.kris.demo.entity;

import com.kris.demo.common.UserSexEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;
    private String userName;
    private String password;
    private UserSexEnum userSex;
    private String nickName;
}
