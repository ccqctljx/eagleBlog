package com.simon.common;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @Author 陈辰强
 * @Date 2017/8/22 22:26
 */
    public class BaseController {
        protected Logger logger = Logger.getLogger(this.getClass());

        /**
         * 得到ModelAndView
         */
        public ModelAndView getModelAndView(){
            return new ModelAndView();
        }

        /**
         * 得到request对象
         */
        public HttpServletRequest getRequest() {

            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }

        /**
         * 得到32位的uuid
         * @return
         */
        public String get32UUID(){
            return UUID.randomUUID().toString().trim().replaceAll("-", "");
        }

    }
