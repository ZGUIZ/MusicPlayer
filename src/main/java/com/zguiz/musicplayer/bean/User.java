package com.zguiz.musicplayer.bean;


import org.springframework.data.annotation.Id;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class User {
    @Id
    private String userName;
    private String passWord;
    private String nickName;
    private String icon;
    private String ipAddress;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();
        if(!StringUtils.isEmpty(userName)){
            map.put("userName",userName);
        }
        if(!StringUtils.isEmpty(nickName)){
            map.put("nickName",nickName);
        }
        if(!StringUtils.isEmpty(icon)){
            map.put("icon",icon);
        }
       if(!StringUtils.isEmpty(ipAddress)){
           map.put("ipAddress",ipAddress);
       }
        return map;
    }
}
