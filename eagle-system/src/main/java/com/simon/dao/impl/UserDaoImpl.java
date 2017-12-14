package com.simon.dao.impl;

import com.simon.dao.UserDao;
import com.simon.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 陈辰强
 * @Date 2017/5/7 0:35
 */
@Component
public class UserDaoImpl implements UserDao {
    @Resource(name = "sqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<User> queryAllUser(){
        return sqlSessionTemplate.selectList("UserMapper.queryAllUser");
    }

    @Override
    public User queryUserByNameAndPass(String userName, String passWord) {
        Map<String ,Object> map = new HashMap<>();
        map.put("userName",userName);
        map.put("passWord",passWord);
        return sqlSessionTemplate.selectOne("UserMapper.queryUserByNameAndPass",map);
    }
}
