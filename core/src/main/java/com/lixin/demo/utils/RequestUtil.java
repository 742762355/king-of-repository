package com.lixin.demo.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lixin
 * @date 2021/12/10 17:03
 * @describe 获取请求中的信息
 */
public class RequestUtil {

    /**
     * 定义移动端请求的所有可能类型
     */
    private final static String[] AGENT = {"Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser"};

    public static boolean isMobile(HttpServletRequest request) {
        return isMobile(request.getHeader("user-agent"));
    }

    @SuppressWarnings("all")
    public static boolean isMobile(String ua) {
        boolean flag = false;
        if (!ua.contains("Windows NT") || (ua.contains("Windows NT") && ua.contains("compatible; MSIE 9.0;"))) {
            // 排除 苹果桌面系统
            if (!ua.contains("Windows NT") && !ua.contains("Macintosh")) {
                for (String item : AGENT) {
                    if (ua.contains(item)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }
}
