package com.example.demo;

import java.io.*;
import java.sql.SQLException;
import java.util.Objects;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "addUser", value = "/addUser")
public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/plain;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String phone=request.getParameter("phone");
        if(Objects.equals(username,null)||Objects.equals(password,null)|| Objects.equals(phone,null)){
            try{
                response.getWriter().println("Bad Request");
                response.setStatus(400);
                return;
            }
            catch (java.io.IOException e){
                e.printStackTrace();
            }
        }
        try{
            JDBCUtil jdbc=new JDBCUtil();
            jdbc.addUser(username,password,phone);
            response.getWriter().println("Add User Success");
            response.setStatus(200);
        }
        catch ( IOException e){
            e.printStackTrace();
        }
        catch (SQLException e){
            try{
                response.getWriter().println("Add User Failed");
                response.setStatus(500);
            }
            catch (java.io.IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request,response);
    }
}