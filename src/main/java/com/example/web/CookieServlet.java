package com.example.web;

import com.example.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: ZongYoucheng
 * DateTime: 2021-12-17 17:07
 */
public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 创建Cookie对象
        Cookie cookie = new Cookie("key1","value1");
        //2. 通知客户端保存Cookie
        resp.addCookie(cookie);

        resp.getWriter().write("Cookie创建成功");
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie iWantCookie = CookieUtils.findCookie("key1",cookies);
        resp.getWriter().write(iWantCookie.getName() + " = " + iWantCookie.getValue());
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方案一：
        //1. 先创建一个要修改的同名的Cookie对象
        //2. 在构造器，同时赋予新的Cookie值
        //Cookie cookie = new Cookie("key1","newValue1");
        //3. 调用response.addCookie(Cookie)，通知客户端保存修改
        //resp.addCookie(cookie);

        //方案二：
        //1. 先查找到需要修改的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1",req.getCookies());
        if (cookie != null) {
            //2. 调用setValue()方法赋予新的Cookie值
            cookie.setValue("newValue1");
            //3. 调用response.addCookie(Cookie)，通知客户端保存修改
            resp.addCookie(cookie);
        }

        resp.getWriter().write("key1的cookie修改完毕");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先找到你要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1",req.getCookies());
        if (cookie != null) {
            //调用setMaxAge(0)
            cookie.setMaxAge(0);//表示马上删除，不需要等待浏览器关闭
            //调用response.addCookie(cookie)
            resp.addCookie(cookie);

            resp.getWriter().write("key1的cookie已经被删除");
        }
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60 * 60);//设置Cookie一小时之后被删除
        resp.addCookie(cookie);

        resp.getWriter().write("已经创建了一个存活一小时的cookie-life3600");
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        //getContextPath()：得到工程路径
        cookie.setPath(req.getContextPath() + "/abc");//得到工程路径/abc

        resp.addCookie(cookie);

        resp.getWriter().write("已经创建了一个带有Path路径的cookie");
    }
}
