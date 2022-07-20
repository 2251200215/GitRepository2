package com.test;


import com.entity.emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbc3 {
    private static String driver="com.mysql.jdbc.Driver";
    static String url="jdbc:mysql://127.0.0.1:3306/mytest?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT";
    static String user="root";
    static String password="root";

    public static void main(String[] agrs) {
       List <emp> emps=testQuery();

        for (emp emp : emps) {
            System.out.println(emp);
        }


    }
public static List<emp> testQuery(){
    List <emp>list=null;
    Connection connection= null;
    Statement statement= null;
    ResultSet resultSet=null;
        try {
        Class.forName(driver);
        //3.获得连接
        connection = DriverManager.getConnection(url,user,password);
        //获得语句对象STATAMENT
        statement = connection.createStatement();
        //执行SQL语句
        String sql="select * from  emp;";
       resultSet= statement.executeQuery(sql);
       list=new ArrayList<>();
        while(resultSet.next()){

        Integer empno=resultSet.getInt("empno");
        String ename=resultSet.getString("ename");
        String job=resultSet.getString("job");
        Integer mgr=resultSet.getInt("mgr");
        Date hiredate=resultSet.getDate("hiredate");
        Double sal=resultSet.getDouble("sal");
        Double comm=resultSet.getDouble("comm");
        Integer deptno=resultSet.getInt("deptno");
        emp emp=new emp(empno,ename,job,mgr,hiredate,sal,comm,deptno);
        list.add(emp);
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
        return list;
    }



}

