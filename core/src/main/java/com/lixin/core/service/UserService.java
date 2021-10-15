package com.lixin.core.service;

import com.lixin.core.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public int update(){
        userMapper.updateById("lx",1);

        userMapper.updateById("lx1",1);
        if (1==1){
            throw new RuntimeException("111");
        }
        return 1;
    }

    @Transactional
    public void trans(){
        userMapper.updateById("lx3",1);
        update();
//        if (1==1){
//            throw new RuntimeException("111");
//        }

    }
}
