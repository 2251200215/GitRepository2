package com.test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc {

    public static void main(String[] agrs) throws Exception {
        /*
        * 向dept表添加一条数据
        * 1、通过反射加载驱动 DRIVER

         */
        Class.forName("com.mysql.jdbc.Driver");
        //3.获得连接
        String url="jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
        String user="root";
        String password="root";

        Connection connection= DriverManager.getConnection(url,user,password);
        //获得语句对象STATAMENT
         Statement statement=  connection.createStatement();
         //执行SQL语句
        String sql="insert into dept values(60,'教学部','北京');";
        int rows=statement.executeUpdate(sql);
        System.out.println("影响数据行数为："+rows);
        //释放资源
        statement.close();
        connection.close();




    }



}

