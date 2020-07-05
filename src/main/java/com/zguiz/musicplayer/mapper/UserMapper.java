package com.zguiz.musicplayer.mapper;

import com.zguiz.musicplayer.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUser(User user);
    int registerUser(User user);
}
