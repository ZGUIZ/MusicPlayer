package com.zguiz.musicplayer.service.impl;

import com.zguiz.musicplayer.bean.User;
import com.zguiz.musicplayer.mapper.UserMapper;
import com.zguiz.musicplayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }
}
