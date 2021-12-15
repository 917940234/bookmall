package com.example.web;

import com.example.pojo.User;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @Author: ZongYoucheng
 * DateTime: 2021-12-08 15:54
 */
class UserServletTest {

    @Test
    void login() {
        System.out.println("这是login()方法调用了");
    }

    @Test
    void regist() {
        System.out.println("这是regist()方法调用了");
    }

    @Test
    void updateUser() {
        System.out.println("这是updateUser()方法调用了");
    }

    @Test
    void updateUserPassword() {
        System.out.println("这是updateUserPassword()方法调用了");
    }

    public static void main(String[] args) {
        String action = "login";

        try {
            //获取action业务鉴别字符串，获取相应的业务方法反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);

            System.out.println(method);
            //调用目标业务方法
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}