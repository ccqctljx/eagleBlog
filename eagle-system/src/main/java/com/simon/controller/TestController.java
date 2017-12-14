package com.simon.controller;

import com.simon.pojo.User;
import com.simon.services.TestDao;
import com.simon.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 陈辰强
 * @Date 2017/5/3 0:22
 */
@Controller(value = "testController")
@RequestMapping("Test")
public class TestController {

    @Autowired
    private UserService userService;

    @Resource(name = "threadPool")
    private TaskExecutor taskExecutor;

    @RequestMapping(value = "/hello", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String hello() {
        String demo = "";
        List<User> users = userService.queryAllUser();
        for (User user : users) {
            demo = "用户名是：" + user.getUserName() + "\r\n + 邮箱是：" + user.getEmail();
        }
        return "hello " + demo;
    }

    @RequestMapping(value = "/demo", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String demo() {
        TestDao td = new TestDao();
        return td.hello();
    }

    @RequestMapping(value = "/task", produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String task() {

        for (int i = 0; i <10; i++) {
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        System.out.println("----------------j is "+j);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            System.out.println("+++++++++++++++++++++i is " + i);
        }

        TestDao td = new TestDao();
        return td.hello();
    }


}
