package com.yida.demo.restcontroller;

import com.yida.demo.entity.User;
import com.yida.demo.service.UserService;
import com.yida.demo.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService (UserService userService) {
        this.userService = userService;
    }

    //  用户注册
    @PostMapping("/register")
    public Result register(@RequestBody User user, HttpSession session) {
        String account = user.getAccount();
        String password = user.getPassword();
        user.setName(account);

        boolean existByAccount = userService.isExistByAccount(account);

        if(existByAccount){
            String message ="该账号已经被使用,不能使用";
            return Result.fail(message);
        }

        user.setPassword(password);
        userService.addUser(user);

        // 注册成功后自动登录
        session.setAttribute("user", user);
        return Result.success();
    }

    //  用户登录
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        String account = user.getAccount();
        String password = user.getPassword();
        User userFromSession = (User) session.getAttribute("user");

        // 检查当前账号是否已登录
        if (userFromSession != null && userFromSession.getAccount().equals(account)) {
            String message ="该账号已登录";
            return Result.fail(message);
        }

        // 用户账号检验
        boolean existByAccount = userService.isExistByAccount(account);
        if (!existByAccount) {
            String message ="账号不存在";
            return Result.fail(message);
        }

        User userFromDatabase = userService.getByAccountAndPassword(account,password);
        // 密码检验
        if (userFromDatabase == null) {
            String message ="登录密码错误";
            return Result.fail(message);
        }
        else {
            session.setAttribute("user", userFromDatabase);
            return Result.success();
        }
    }

    //  用户退出登录(需要页面转跳，放在ForeController里面)

    // 更新用户信息
    @PostMapping("/updateUserForNameAndPassword")
    public Result updateUserForNameAndPassword(@RequestBody User user, HttpSession session) {
        User userFromSession = (User) session.getAttribute("user");
        User userFromDatabase = userService.getByAccountAndPassword(userFromSession.getAccount(), userFromSession.getPassword());
        // 设置阶段
        userFromDatabase.setName(user.getName());
        userFromDatabase.setPassword(user.getPassword());
        userService.updateUser(userFromDatabase);
        session.setAttribute("user", userFromDatabase);
        // 验证阶段
        return Result.success();
    }

    //  检查是否登录有已登录用户
    @GetMapping("/checkLogin")
    public Result checkLogin(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user == null) {
            return Result.fail("Session内无登录用户");
        }
        else {
            return Result.success();
        }
    }



}
