package com.example.web;

import com.mysql.cj.jdbc.ha.ReplicationMySQLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: ZongYoucheng
 * DateTime: 2021-12-18 15:08
 */
public class SessionServlet extends BaseServlet {

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session会话对象
        HttpSession session = req.getSession();
        //判断当前Session回话，是否是新创建出来的
        boolean isNew = session.isNew();
        //获取Session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的session，它的id是：" + id + "<br/>");
        resp.getWriter().write("这个session是否是新创建的：" + isNew + "<br/>");
    }

    /**
     * 往session中保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("已经往session中保存了数据");
    }

    /**
     * 获取session域中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从session中获取出key1的数据是：" + attribute);
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取了session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时长为：" + maxInactiveInterval + "秒");
    }

    /**
     * 3秒后销毁session
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //设置当前session3秒后超时
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("当前session已经设置为3秒后超时");
    }

    /**
     * 马上销毁session
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session对象
        HttpSession session = req.getSession();
        //让session会话马上超时
        session.invalidate();

        resp.getWriter().write("session会话已超时");
    }
}
