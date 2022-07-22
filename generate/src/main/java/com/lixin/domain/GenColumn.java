package com.lixin.domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenColumn {

    private String tableSchema;

    private String tableName;

    private String columnName;//表的字段名

    private String name;//实体的字段名

    private String isNullable;

    private String columnDefault;

    private String dataType;

    private String columnKey;

    private String columnComment;

    private List<String> annotationKeys = new LinkedList<>();

    private Map<String, Map<String, String>> annotationMap = new HashMap<>();

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColumnKey() {
        return columnKey;
    }

    public void setColumnKey(String columnKey) {
        this.columnKey = columnKey;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public List<String> getAnnotationKeys() {
        return annotationKeys;
    }

    public void setAnnotationKeys(List<String> annotationKeys) {
        this.annotationKeys = annotationKeys;
    }

    public Map<String, Map<String, String>> getAnnotationMap() {
        return annotationMap;
    }

    public void setAnnotationMap(Map<String, Map<String, String>> annotationMap) {
        this.annotationMap = annotationMap;
    }
}
