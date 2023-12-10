package com.zguiz.musicplayer.controller;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.zguiz.musicplayer.bean.Shopping;
import com.zguiz.musicplayer.bean.User;
import com.zguiz.musicplayer.elasticsearch.ElasticClient;
import com.zguiz.musicplayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    @ResponseBody
    public int register(User user){
        return userService.registerUser(user);
    }

    /**
     * 用于测试数据库链接，没有任何用处
     * @return
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(){
        User user = new User();
            user.setUserName("ZGUIZ");

        return userService.getUser(user);
    }

    @RequestMapping("/queryShopping")
    @ResponseBody
    public List<Shopping> queryShopping(){
        ElasticClient elasticClient = new ElasticClient();
        ElasticsearchClient client = elasticClient.getClient();
        try {
            //添加数据
            //elasticClient.addData(client);
            //查询
            List<Shopping> shoppings = elasticClient.searchAll(client);
            return shoppings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/queryShoppingByCategory")
    @ResponseBody
    public List<Shopping> queryShoppingByCategory(){
        ElasticClient elasticClient = new ElasticClient();
        ElasticsearchClient client = elasticClient.getClient();
        try {
            //添加数据
            //elasticClient.addData(client);
            //查询
            List<Shopping> shoppings = elasticClient.searchByCategory(client, "shopping", "小米");
            return shoppings;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public User login(User user){
        return userService.login(user,getRequest());
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(User user){
        userService.logout(user,getRequest());
        return "success";
    }

    /**
     * 用于测试redis，没有任何用处
     * @return
     */
    @RequestMapping("/getRedisInfo")
    @ResponseBody
    public User getInfo(){
        User user = new User();
        user.setUserName("ZGUIZ");
        return userService.getRedisInfo(user);
    }
}
