package club.chillrainqcna.controller;

import club.chillrainqcna.bean.User;
import club.chillrainqcna.bean.result.Result;
import club.chillrainqcna.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ChillRain 2023 02 12
 */
@RestController//用户CPU 用来转发到特定的Service
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        System.out.println("login-----");
        System.out.println("login user: " + user.getUsername());
        return userService.login(user);
    }
    @PostMapping("/register")
    @CrossOrigin
    public String register(@RequestBody User user){
        System.out.println("register-----");
        System.out.println("regist user: " + user.getUsername());
        return userService.register(user);
    }
}
