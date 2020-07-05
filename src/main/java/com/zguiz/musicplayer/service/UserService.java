package com.zguiz.musicplayer.service;

import com.zguiz.musicplayer.bean.User;

public interface UserService {
    User getUser(User user);
    int registerUser(User user);
}
