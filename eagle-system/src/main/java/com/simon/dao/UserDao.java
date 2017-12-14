package com.simon.dao;

import com.simon.pojo.User;

import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2017/5/7 0:21
 */
public interface UserDao {
    List<User> queryAllUser();

    User queryUserByNameAndPass(String userName, String passWord);
}
