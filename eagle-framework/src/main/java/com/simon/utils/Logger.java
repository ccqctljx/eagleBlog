package com.simon.utils;

/**
 * @Author 陈辰强
 * @Date 2018/1/8 21:19
 */
public class Logger {

    public static void debug(String moduleName, String content) {
        try {
            Class clazz = Class.forName(moduleName);
            org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(clazz);
//
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH24:mm:ss");
//        String currentTime = sdf.format(date);

            logger.debug(content);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
