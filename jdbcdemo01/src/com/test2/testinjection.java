package com.test2;

import com.entity.account2;
import com.entity.emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class testinjection {
    private static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
    static String user="root";
    static String password="root";

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("please load the username:");
        String username=sc.next();
        System.out.println("please load the pwd:");
        String pwd=sc.next();
        account2 account2=findbypassword(username,pwd);
        System.out.println(account2==null?"登陆失败":"登陆成功");
    }

    public static account2 findbypassword(String username,String pwd){

        Connection connection= null;
        Statement statement= null;
        ResultSet resultSet=null;
        account2 account02=null;
        try {
            Class.forName(driver);
            //3.获得连接
            connection = DriverManager.getConnection(url,user,password);
            //获得语句对象STATAMENT
            statement = connection.createStatement();
            //执行SQL语句
            String sql="select * from  account2 where username='"+username+"' and password='"+pwd+"';";
            resultSet= statement.executeQuery(sql);
            System.out.println(sql);
            while(resultSet.next()){

                Integer aid=resultSet.getInt("aid");
                String usernamea=resultSet.getNString("username");
                String password=resultSet.getNString("password");
                Double money=resultSet.getDouble("money");
                 account02=new account2(aid,usernamea,password,money);
                System.out.println(account02);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        finally {
            if (null!=resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (null != statement) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return account02;

    }
}
