package com.zguiz.musicplayer.service;

import com.zguiz.musicplayer.bean.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User getUser(User user);
    int registerUser(User user);
    User login(User user, HttpServletRequest request);
    User login(String userName,String Password, HttpServletRequest request);
    User getRedisInfo(User user);
    void logout(User user,HttpServletRequest request);
}
