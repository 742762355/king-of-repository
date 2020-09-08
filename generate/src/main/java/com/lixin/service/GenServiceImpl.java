package com.lixin.service;

import com.lixin.config.PropertiesConfig;
import com.lixin.domain.GenColumn;
import com.lixin.domain.GenInfo;
import com.lixin.mapper.GenMapper;
import com.lixin.util.GenUtils;
import com.lixin.util.VelocityInitializer;
import com.lixin.util.VelocityUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.StringWriter;
import java.util.List;

@Service
public class GenServiceImpl implements GenService{

    @Autowired
    private GenMapper genMapper;

    public void gen(){
        List<GenColumn> columns = genMapper.selectColumns(PropertiesConfig.tableName, PropertiesConfig.databaseName);
        String tableComment = genMapper.selectTableComment(PropertiesConfig.tableName, PropertiesConfig.databaseName);
        GenInfo template=new GenInfo();
        if (StringUtils.isNotEmpty(tableComment)){
            template.tableComment=tableComment;
        }
        //todo 简单模式 simpleMode()
        if (columns.size()==0)return;
        loadInfo(template,columns);
        VelocityInitializer.initVelocity();
        VelocityContext context = VelocityUtils.prepareContext(template);
        List<String> renderTemplate = VelocityUtils.getRenderTemplate();
        for (String render : renderTemplate) {
            StringWriter writer=new StringWriter();
            Template tpl = Velocity.getTemplate(render, "UTF-8");
            tpl.merge(context,writer);
            //todo 多个目录 根据template 获取
            try {
                String path="D:/data/template/SysUser.java";
                File file = new File(path);
                if (file.getParentFile()!=null&&!file.getParentFile().exists()){
                    file.getParentFile().mkdirs();
                }
                FileUtils.writeStringToFile(file,writer.toString(),"UTF-8");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private void loadInfo(GenInfo template, List<GenColumn> columns) {
        template.columns=columns;
        //根据字段名是否包含fk筛选出param参数
        for (GenColumn column : columns) {
            if (template.isPK(column.getColumnName())){
                template.pkName=column.getColumnName();
            }
            //获取驼峰名
            String name = GenUtils.toHump(column.getColumnName());
            column.setName(name);
            GenUtils.typeConvert(column);
            GenUtils.typeClassConvert(template.importClass,column.getDataType());
            GenUtils.makeAnnotation(template.importClass,column);
        }
        if (StringUtils.isEmpty(template.pkName)){
            String columnName = columns.get(0).getColumnName();
            template.pkName=columnName;
        }
    }

}
