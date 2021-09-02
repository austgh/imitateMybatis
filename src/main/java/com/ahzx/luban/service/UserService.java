package com.ahzx.luban.service;

import com.ahzx.luban.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void test(){
        userMapper.selectById(1);
    }

}
