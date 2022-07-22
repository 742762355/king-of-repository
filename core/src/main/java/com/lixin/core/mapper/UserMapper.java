package com.lixin.core.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    int updateById(@Param("name") String name, @Param("id") Integer id);
}
