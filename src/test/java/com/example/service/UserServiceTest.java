package com.example.service;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"bbj168","666666","bbj168@qq.com"));
        userService.registUser(new User(null,"abc168","888888","abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"zongyoucheng","123456","917940234@qq.com")));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("zongyoucheng")) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可用");
        }
    }
}