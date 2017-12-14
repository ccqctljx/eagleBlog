package com.simon.controller;

import com.simon.common.BaseController;
import com.simon.pojo.User;
import com.simon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2017/8/14 23:39
 */
@Controller(value = "sysConrotller")
@RequestMapping("system")
public class SysController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toLogin")
    public String toLogin(){
        return "system/login";
    }

    @RequestMapping(value = "/login_login", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String login(@RequestParam(value = "userName", required = true) String userName,
                 @RequestParam(value = "passWord", required = true) String passWord) {

        if (userName.isEmpty() || passWord.isEmpty()) {
            return "redirect:toLogin";
        }
        String res = "";
        User user = userService.queryUserByNameAndPass(userName,passWord);
        if(user == null){
            return "redirect:toLogin";
        }
            res = "用户名是：" + user.getUserName() + "\r\n + 邮箱是：" + user.getEmail();
        return "hello " + res;
    }




}
