package com.simon.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


/**
 * @Author 陈辰强
 * @Date 2017/10/12 21:41
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@WebAppConfiguration
//告诉junit spring配置文件
@ContextConfiguration("classpath*:spring/spring-config*.xml")                  //我是放在classpath下的，可以根据自己的路径改
public class BaseTest {
}
