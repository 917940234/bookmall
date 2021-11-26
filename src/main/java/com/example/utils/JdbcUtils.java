package com.example.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            //读取jdbc.properties属性配置文件
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 获取数据库连接池中的连接
     * @return 如果返回null，说明获取连接失败，有值就是获取连接成功
     */
    public static Connection getConnection() {

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 关闭连接，放回数据库连接池
     * @param connection
     */
    public static void close(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
