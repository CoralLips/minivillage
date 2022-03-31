package com.yida.demo.restcontroller;


import com.yida.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ForeRestController {
    private UserService userService;
    @Autowired
    public void setUserService (UserService userService) {
        this.userService = userService;
    }


}
