package com.lixin.mapper;

import com.lixin.domain.GenColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GenMapper {

    List<GenColumn> selectColumns(@Param("tableName") String tableName, @Param("databaseName") String databaseName);

    String selectTableComment(@Param("tableName") String tableName, @Param("databaseName") String databaseName);
}
