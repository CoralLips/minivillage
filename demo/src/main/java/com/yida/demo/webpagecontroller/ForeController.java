package com.yida.demo.webpagecontroller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ForeController {
    //
    @GetMapping("/hello")
    public String hello(){ return "fore/hello"; }

    @GetMapping("/home")
    public String home(){ return "fore/home"; }

    @GetMapping("/hall")
    public String hall(){ return "fore/hall"; }

    @GetMapping("/world")
    public String world(){ return "fore/world"; }

    @GetMapping("/list")
    public String list(){ return "fore/list"; }

    // 登录注册
    @GetMapping("/login")
    public String login(){
        return "fore/login";
    }

    @GetMapping("/register")
    public String register(){ return "fore/register"; }

    // 用户中心
    @GetMapping("/userCenter")
    public String userCenter(){ return "fore/userCenter"; }

    @GetMapping("/villageCenter")
    public String villageCenter(){ return "fore/villageCenter"; }

    // 退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "fore/home";
    }

    // 测试栏映射
    @GetMapping("/test")
    public String test(){
        return "fore/test";
    }

    @GetMapping("/test1")
    public String test1(){
        return "fore/test1";
    }
}
