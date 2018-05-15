package com.simon.shiro;

import com.simon.pojo.User;
import com.simon.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2018/5/8 23:18
 */
@Component("customRealm")
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;


    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        // 获取身份信息
        String username = (String) principalCollection.getPrimaryPrincipal();
        // 根据身份信息从数据库中查询权限数据
        // 这里使用静态数据模拟
        List<String> permissions = new ArrayList<String>();
        permissions.add("user:*");
        permissions.add("department:*");

        // 将权限信息封闭为AuthorizationInfo
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 模拟数据，添加 manager 角色
        simpleAuthorizationInfo.addRole("administrator");

        for (String permission : permissions) {
            simpleAuthorizationInfo.addStringPermission(permission);
        }

        return simpleAuthorizationInfo;

    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        // 从 token 中获取用户身份信息
        String username = (String) authenticationToken.getPrincipal();
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        session.setAttribute("loginName", authenticationToken);

        // 通过 username 从数据库中查询
        User user = userService.queryUserByName(username);

        // 如果查询不到则返回 null
        if (null == user) {//这里模拟查询不到
            throw new AuthenticationException("msg:无此账号");
        }

        //返回认证信息由父类 AuthenticatingRealm 进行认证
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(new Principal(user), user.getUserPass(), getName());

        return simpleAuthenticationInfo;
    }

}
