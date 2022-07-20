package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc2 {
    private static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
    static String user="root";
    static String password="root";

    public static void main(String[] agrs) {
        /*
        * 向dept表添加一条数据
        * 1、通过反射加载驱动 DRIVER

         */
        Connection connection= null;
        Statement statement= null;
        try {
            Class.forName(driver);
            //3.获得连接
            connection = DriverManager.getConnection(url,user,password);
            //获得语句对象STATAMENT
            statement = connection.createStatement();
            //执行SQL语句
            String sql="insert into dept values(70,'教学部','北京');";
            int rows=statement.executeUpdate(sql);
            System.out.println("影响数据行数为："+rows);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            if (null!=statement) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (null!=connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            }
        }
        //释放资源





    }



}

