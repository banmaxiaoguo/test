package com.ghw.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class BMIServlet extends HttpServlet {
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
        //把数据存入到reques
        request.setAttribute("msg",msg);
        request.getRequestDispatcher("/result.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
