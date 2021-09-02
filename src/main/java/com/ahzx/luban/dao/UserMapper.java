package com.ahzx.luban.dao;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select user")
    public void selectById(Integer i);
}
