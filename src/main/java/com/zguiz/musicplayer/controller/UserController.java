package com.zguiz.musicplayer.controller;

import com.zguiz.musicplayer.bean.User;
import com.zguiz.musicplayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public int register(User user){
        return userService.registerUser(user);
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(){
        User user = new User();
        user.setUserName("ZGUIZ");
        return userService.getUser(user);
    }
}
