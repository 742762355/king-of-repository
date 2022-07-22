package com.lixin.util;

import com.lixin.config.PropertiesConfig;
import com.lixin.domain.GenInfo;
import common.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.VelocityContext;

import java.util.ArrayList;
import java.util.List;

public class VelocityUtils {


    public static VelocityContext prepareContext(GenInfo info) {
        String tableName = PropertiesConfig.tableName;

        VelocityContext context = new VelocityContext();

        context.put("packageName", PropertiesConfig.packageName);
        context.put("author", PropertiesConfig.author);
        context.put("datetime", DateUtils.now());
        context.put("prefix", tableName.split("_")[0]);
        context.put("tableName", StringUtils.capitalize(GenUtils.toHump(tableName)));
        context.put("_tableName", StringUtils.upperCase(tableName));
        context.put("exampleName", GenUtils.toHump(tableName));
        context.put("tableComment", info.tableComment);
        context.put("importClass", info.importClass);
        context.put("columns", info.columns);
        context.put("pkName", info.pkName);
        return context;
    }

    public static List<String> getRenderTemplate() {
        List<String> renderList = new ArrayList<>();
        renderList.add("vm/java/domain.java.vm");
        return renderList;
    }
}
