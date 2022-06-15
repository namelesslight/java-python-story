package com.example.javapythonstory.code.controller;

import com.example.javapythonstory.code.result.WebResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/base")
@RestController
public class ErrorController {

    /**
     * 错误的跳转
     * @return
     */
    @RequestMapping("/error")
    public WebResult error(){
        Map<String,Object> message = new HashMap<>();
        message.put("code","-1");
        message.put("info","token错误，需要重新登录");
        return new WebResult().result200(message,"/base/error");
    }

    /**
     * token过期跳转
     * @return
     */
    @RequestMapping("/timeout")
    public WebResult timeout(){
        Map<String,Object> message = new HashMap<>();
        message.put("code","-2");
        message.put("info","错误，token已过期");
        return new WebResult().result200(message,"/base/timeout");
    }

    /**
     * 用户无权限跳转
     * @return
     */
    @RequestMapping("/noPerm")
    public WebResult noPerm(){
        Map<String,Object> message = new HashMap<>();
        message.put("code","-3");
        message.put("info","错误，无权限");
        return new WebResult().result200(message,"/base/noPerm");
    }

    /**
     * 用户未登录跳转
     * @return
     */
    @RequestMapping("/noLogin")
    public WebResult noLogin(){
        Map<String,Object> message = new HashMap<>();
        message.put("code","0");
        message.put("info","未登录");
        return new WebResult().result200(message,"/base/noLogin");
    }

}
