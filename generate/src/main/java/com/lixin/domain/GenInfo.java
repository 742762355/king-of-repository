package com.lixin.domain;

import com.lixin.config.PropertiesConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenInfo {

    public String pkName;//主键名

    public String tableComment;//表备注

    public List<GenColumn> columns;

    public Set<String> importClass;

    public boolean isPK(String columnName){
        return columnName.equals("PK");
    }

    public GenInfo() {
        this.importClass = new HashSet<>();
        this.importClass.add("javax.persistence.Column");
        this.importClass.add("javax.persistence.Table");
        this.importClass.add(PropertiesConfig.packageName+".domain.base.BaseEntity");
    }

}
