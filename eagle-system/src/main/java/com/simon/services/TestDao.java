package com.simon.services;

import com.simon.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2017/5/11 16:52
 */
@Component
public class TestDao {
    @Autowired
    private UserService userService;

    public String hello() {
        String demo = "";
        List<User> users = userService.queryAllUser();
        for (User user : users) {
            demo = "用户名是：" + user.getUserName() + "\r\n + 邮箱是：" + user.getEmail();
        }
        return "hello " + demo;
    }
}
