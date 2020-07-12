package com.zguiz.musicplayer.service.impl;

import com.zguiz.musicplayer.bean.User;
import com.zguiz.musicplayer.mapper.UserMapper;
import com.zguiz.musicplayer.service.UserService;
import com.zguiz.musicplayer.utils.IpAddressUtil;
import com.zguiz.musicplayer.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {

    public static final String LOGIN = "loginInfo.";
    public static final String SESSION = "session.";

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private Jedis jedis;

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }

    @Override
    public User login(User user, HttpServletRequest request) {
        if(StringUtils.isEmpty(user.getUserName())){
            throw new RuntimeException("用户名不能为空");
        }
        if(StringUtils.isEmpty(user.getPassWord())){
            throw new RuntimeException("密码不能为空");
        }

        User userMessage = userMapper.getUser(user);
        if(userMessage == null ){
            throw new RuntimeException("用户密码错误！");
        }
        userMessage.setIpAddress(IpAddressUtil.getIpAddress(request));
        //利用redis记录登录消息
        insertRedis(userMessage);
        return userMapper.getUser(user);
    }

    @Override
    public User login(String userName,String password, HttpServletRequest request) {
        User user = new User();
        user.setUserName(userName);
        user.setPassWord(password);
        return login(user,request);
    }

    @Override
    public User getRedisInfo(User user) {
        User result = new User();
        result.setUserName(jedis.hget(LOGIN+user.getUserName(),"userName"));
        result.setIcon(jedis.hget(LOGIN+user.getUserName(),"icon"));
        result.setNickName(jedis.hget(LOGIN+user.getUserName(),"nickName"));
        result.setIpAddress(jedis.hget(LOGIN+user.getUserName(),"ipAddress"));
        return result;
    }

    @Override
    public void logout(User user, HttpServletRequest request) {
        delRedis(user);
    }

    //插入到redis中
    private void insertRedis(User user){
        //检查用户是否已经登录
        if(jedis.hexists(LOGIN+user.getUserName(),"userName")){
            throw new RuntimeException("用户已经登录");
        }
        //将用户信息存放入reids
        jedis.hmset(LOGIN+user.getUserName(),user.toMap());
    }

    //从redis中删除
    private void delRedis(User user){
        if(jedis.hexists(LOGIN+user.getUserName(),"userName")){
            jedis.hdel(LOGIN+user.getUserName(),"userName","nickName","icon","ipAddress");
        }
    }
}
