package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String JDBC_USERNAME="root";
    private static final String JDBC_PWD="wpc63385133.";
    public void addUser(String username,String password,String phone) throws SQLException {
        try(Connection conn= DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PWD)){
            String sql="insert into users(username,password,phone) values(?,?,?)";
            try(java.sql.PreparedStatement ps=conn.prepareStatement(sql)){
                ps.setString(1,username);
                ps.setString(2,password);
                ps.setString(3,phone);
                ps.executeUpdate();
            }
        }
    }
    public void deleteUser(String username) throws SQLException {
        try(Connection conn= DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PWD)){
            String sql="delete from users where username=?";
            try(java.sql.PreparedStatement ps=conn.prepareStatement(sql)){
                ps.setString(1,username);
                ps.executeUpdate();
            }
        }
    }
    public void updateUser(String username,String password,String phone) throws SQLException {
        try(Connection conn= DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PWD)){
            String sql="update users set password=?,phone=? where username=?";
            try(java.sql.PreparedStatement ps=conn.prepareStatement(sql)){
                ps.setString(1,password);
                ps.setString(2,phone);
                ps.setString(3,username);
                ps.executeUpdate();
            }
        }
    }
    public String getPassword(String username) throws SQLException {
        try(Connection conn= DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PWD)){
            String sql="select password from users where username=?";
            try(java.sql.PreparedStatement ps=conn.prepareStatement(sql)){
                ps.setString(1,username);
                try(java.sql.ResultSet rs=ps.executeQuery()){
                    if(rs.next()){
                        return rs.getString("password");
                    }
                    return null;
                }
            }
        }
    }
    public String getPhone(String username) throws SQLException {
        try(Connection conn= DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PWD)){
            String sql="select phone from users where username=?";
            try(java.sql.PreparedStatement ps=conn.prepareStatement(sql)){
                ps.setString(1,username);
                try(java.sql.ResultSet rs=ps.executeQuery()){
                    if(rs.next()){
                        return rs.getString("phone");
                    }
                    return null;
                }
            }
        }
    }
    public JDBCUtil() throws SQLException {
    }
}
