package com.zguiz.musicplayer.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

@Component
public class RedisUtil {
    private static Jedis jedis;

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public Jedis getJedis() {
        if(jedis == null){
            synchronized (RedisUtil.class){
                if(jedis == null){
                    jedis = new Jedis(host,port);
                    if(!StringUtils.isEmpty(password)) {
                        jedis.auth(password);
                    }
                }
            }
        }
        return jedis;
    }
}
