package com.example.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.RequestFormatUtils;

import java.io.IOException;
import java.util.Map;

@WebServlet("/test")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String queryString = req.getQueryString();
        System.out.println(queryString);
//        resp.setHeader("Content-Type", "text/html;charset=utf-8");
//        resp.getWriter().write("<span>" + name + "hello" + "</span>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        Map<String, Object> objectMap = RequestFormatUtils.parseRequestBodyToMap(req);
        System.out.println("objectMap = " + objectMap);
    }
}
