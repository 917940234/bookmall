package com.example.web;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //2. 检查验证码是否正确，写死，要求验证码为：6n6np
        if ("6n6np".equalsIgnoreCase(code)) {
            //3. 检查用户名是否可用
            if (userService.existsUsername(username)) {
                System.out.println("用户名[" + username + "]已存在！");
                //跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
            } else {
                //调用Service保存到数据库，跳到注册成功页面regist_success.html
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
            }
        } else {
            //跳回注册页面
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
