package com.simon.services;

import com.simon.pojo.User;

import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2017/5/7 0:31
 */
public interface UserService {
    List<User> queryAllUser();

    User queryUserByNameAndPass(String userName, String passWord);
}
