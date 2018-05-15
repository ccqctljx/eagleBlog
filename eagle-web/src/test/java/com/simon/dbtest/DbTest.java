package com.simon.dbtest;

import com.simon.pojo.User;
import com.simon.services.UserService;
import com.simon.common.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2017/10/12 21:38
 */
public class DbTest extends BaseTest {
    @Autowired
    private UserService userService;

    @Test
    public void testDb(){
        List<User> users = userService.queryAllUser();
        for (User user : users){
            System.out.println(user.getNickName());
        }
    }

}
