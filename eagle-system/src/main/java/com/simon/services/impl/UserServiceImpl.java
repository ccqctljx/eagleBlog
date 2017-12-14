package com.simon.services.impl;

import com.simon.dao.UserDao;
import com.simon.pojo.User;
import com.simon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2017/5/7 0:36
 */
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public User queryUserByNameAndPass(String userName, String passWord) {
        return userDao.queryUserByNameAndPass(userName, passWord);
    }


}
