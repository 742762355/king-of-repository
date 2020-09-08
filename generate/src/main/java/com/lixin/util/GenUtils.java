package com.lixin.util;

import com.lixin.domain.GenColumn;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GenUtils {

    private static Pattern humpPattern = Pattern.compile("[A-Z]");
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /**
     * @author:lixin
     * @date:2020/8/28  16:55
     * @description: 驼峰转下划线+小写
     */
    public static String humpToUpper(String name){
        Matcher matcher=humpPattern.matcher(name);
        StringBuffer sb=new StringBuffer();
        while (matcher.find()){
            matcher.appendReplacement(sb,"_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString().toUpperCase();
    }


    /**
     * @author:lixin
     * @date:2020/8/28  16:56
     * @description: 小写转驼峰
     */
    public static String toHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static String typeConvert(GenColumn column) {
        String dataType=column.getDataType();
        String type;
        switch (dataType){
            case "char":
            case "text":
            case "varchar":type="String";break;
            case "int":
            case "tinyint":
            case "smallint":type="Integer";break;
            case "timestamp":
            case "date":type="Date";break;
            default:type="String";
        }
        column.setDataType(type);
        return type;
    }

    public static void typeClassConvert(Set<String> sets,String name){
        switch (name){
            case "String":sets.add("java.lang.String");break;
            case "Integer":sets.add("java.lang.Integer");break;
            case "Date":sets.add("java.util.Date");break;
        }
    }

    public static void makeAnnotation(Set<String> importClass,GenColumn column) {
        List<String> annotationKeys = column.getAnnotationKeys();
        Map<String, Map<String, String>> annotationMap = column.getAnnotationMap();
        addDefault(column);
        if ("NO".equals(column.getIsNullable())){
            annotationKeys.add("@NotBlank");//注解名
            //注解的k,y
            Map<String,String> annotationFields=new HashMap<>();
            annotationFields.put("message",column.getColumnComment()+"不能为空!");
            annotationMap.put("@NotBlank",annotationFields);
            importClass.add("javax.validation.constraints.NotBlank");
        }
        if (column.getDataType().equals("Date")){
            annotationKeys.add("@JsonFormat");//日期序列化
            annotationKeys.add("@DateTimeFormat");

            Map<String,String> annotationJsonFormat=new HashMap<>();
            annotationJsonFormat.put("timezone","GMT+8");
            annotationJsonFormat.put("pattern","yyyy-MM-dd");
            annotationMap.put("@JsonFormat",annotationJsonFormat);

            Map<String,String> annotationDateTimeFormat=new HashMap<>();
            annotationDateTimeFormat.put("pattern","yyyy-MM-dd");
            annotationMap.put("@DateTimeFormat",annotationDateTimeFormat);

            importClass.add("com.fasterxml.jackson.annotation.JsonFormat");
            importClass.add("org.springframework.format.annotation.DateTimeFormat");

        }

    }

    private static final String defaultKey="@Column";
    private static final String defaultFieldKey="name";
    private static void addDefault(GenColumn column) {
        List<String> annotationKeys = column.getAnnotationKeys();
        Map<String, Map<String, String>> annotationMap = column.getAnnotationMap();
        annotationKeys.add(defaultKey);
        Map<String,String> annotationFields=new HashMap<>();
        annotationFields.put(defaultFieldKey,column.getColumnName());
        annotationMap.put(defaultKey,annotationFields);
    }

}
