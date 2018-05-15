package com.simon.shiro;


import com.simon.pojo.User;

import java.io.Serializable;

/**
 * shiro登入保存的用户
 *
 */
public class Principal implements Serializable{
    private String id; // 编号
    private String loginName; // 登录名
    private String name; // 姓名

    public Principal(User user) {
        this.id = user.getUserId();
        this.loginName = user.getUserName();
        this.name = user.getNickName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
