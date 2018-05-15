package com.simon.controller;

import com.simon.common.BaseController;
import com.simon.pojo.User;
import com.simon.services.UserService;
import com.simon.shiro.Principal;
import com.simon.shiro.ShiroUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2017/8/14 23:39
 */
@Controller(value = "sysConrotller")
public class SysController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "system/login";
    }

    @RequestMapping(value = "/login_login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {

        Principal principal = ShiroUtils.getPrincipal();//获取当前登入者用户
        //如果已经登入了,则跳转到管理页面
        if (principal != null) {
            return "redirect:index";
        }
            return "system/login";
    }

    @RequestMapping(value = "/toIndex")
    public String toIndex(){
        return "index";
    }
}
