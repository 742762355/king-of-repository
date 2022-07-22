package com.lixin.core.utils;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private static String regEx = "[~!/@#$%^&*()-_=+\\|[{}];:\'\",<.>/?]+";


    /**
     * @author:lixin
     * @date:2020/5/23 8:58
     * @description: 判断是否匹配某些字符串
     */
    public static boolean isMatch(String s) {
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(s);
        return matcher.find();
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return !isNotEmpty(str);
    }

    /**
     * 判断字符串是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

    /**
     * 字符串模板替换
     * 模板格式 ${key}；参数格式"{key:'值'}"
     *
     * @param content
     * @param param
     * @return
     */
    public static String template(String content, String param) {
        if (StringUtil.isEmpty(param)) {
            String regex = "\\$\\{\\w+\\}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll("");
            return content;
        }
        JSONObject jsonObject = JSONObject.parseObject(param);
        return template(content, jsonObject);
    }

    /**
     * 字符串模板替换
     * 模板格式 ${key}；参数格式 JsonObject: {key:'值'}
     *
     * @param content
     * @param jsonObject
     * @return
     */
    public static String template(String content, JSONObject jsonObject) {
        for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
            String regex = "\\$\\{" + entry.getKey() + "\\}";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(content);
            String value = entry.getValue() == null ? "" : entry.getValue().toString();
            content = matcher.replaceAll(value);
        }
        String regex = "\\$\\{\\w+\\}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        content = matcher.replaceAll("");
        return content;
    }


    /**
     * @author:lixin
     * @date:2020/5/23 8:59
     * @description: 验证是否是手机号, (电话号码可能不支持) 辣鸡正则有问题
     */
    public static boolean isMobile(final String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }
}
