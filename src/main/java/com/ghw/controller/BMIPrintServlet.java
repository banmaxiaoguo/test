package com.ghw.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BMIPrintServlet", value = "/BMIPrintServlet")
public class BMIPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String height = request.getParameter("h");
        String weight = request.getParameter("w");
        float h=Float.valueOf(height);
        float w=Float.valueOf(weight);
        float bmi=w/(h*h);
        String msg="";
        if(bmi<=18.5){
            msg="瘦";
        }else if(23.9>=bmi&& bmi>18.5){
            msg="正常";
        }else if(27>=bmi&& bmi>24){
            msg="胖";
        }else {
            msg="胖死";
        }
        msg="你好："+name+"你的bmi值是："+msg;
        //使用httpservletreponse输出数据
        response.setContentType("text/html;charset=utf-8");
    PrintWriter pw=response.getWriter();
    pw.println(msg);
    pw.flush();
    pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
