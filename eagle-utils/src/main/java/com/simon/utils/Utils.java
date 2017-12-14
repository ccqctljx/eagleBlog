package com.simon.utils;

import java.util.UUID;

/**
 * @Author 陈辰强
 * @Date 2017/8/22 22:23
 */
public class Utils {

    /**
     * 获取
     * @return
     */
    public static String get32UUID() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}
