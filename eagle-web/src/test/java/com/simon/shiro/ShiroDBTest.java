package com.simon.shiro;

import com.simon.common.BaseTest;
import com.simon.pojo.User;
import com.simon.services.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2018/5/9 22:10
 */
@Component
public class ShiroDBTest extends BaseTest {
    @Autowired
    UserService userService;

    @Autowired
    CustomRealm customRealm;

    @Test
    public void testCustomRealm(){
        // 读取 shiro.ini 文件内容
//        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            System.out.println("someKey 的值：" + value);
        }

        // 登陆
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "admin");
        token.setRememberMe(true);
        try {
            currentUser.login(token);
        } catch (UnknownAccountException uae) {
            System.out.println("用户名不存在:" + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
            System.out.println("账户密码 " + token.getPrincipal() + " 不正确!");
        } catch (LockedAccountException lae) {
            System.out.println("用户名 " + token.getPrincipal() + " 被锁定 !");
        } catch (AuthenticationException ae){
            System.out.println("用户名 " + token.getPrincipal() + "未认证");
            ae.printStackTrace();
        }

        // 认证成功后
        if (currentUser.isAuthenticated()) {

            System.out.println("用户 " + currentUser.getPrincipal() + " 登陆成功！");

            //测试角色
            System.out.println("是否拥有 manager 角色：" + currentUser.hasRole("manager"));

            //测试权限
            System.out.println("是否拥有 user:create 权限" + currentUser.isPermitted("user:create"));

            //测试hasAllRoles
            List<String> list = new ArrayList<>();
            list.add("manager");
//            list.add("user:create");
            System.out.println("是否拥有全部权限 "+ currentUser.hasAllRoles(list));
            //退出
            currentUser.logout();
        }
    }
}
