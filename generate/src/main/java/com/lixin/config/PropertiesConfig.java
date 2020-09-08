package com.lixin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "gen")
public class PropertiesConfig {

    public static String tableName;

    public static String packageName;

    public static String author;

    public static String databaseName;

    public void setTableName(String tableName) {
        PropertiesConfig.tableName = tableName;
    }

    public void setPackageName(String packageName) {
        PropertiesConfig.packageName = packageName;
    }

    public void setAuthor(String author) {
        PropertiesConfig.author = author;
    }

    public void setDatabaseName(String databaseName) {
        PropertiesConfig.databaseName = databaseName;
    }
}
