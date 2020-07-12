package com.zguiz.musicplayer.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseController {
    public HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public HttpServletResponse getResponse(){
        return  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public HttpSession getSession(){
        return  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }
}
