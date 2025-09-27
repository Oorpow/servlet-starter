package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.VerifyCodeUtil;

import java.io.IOException;

@WebServlet("/code")
public class VerifyCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream outputStream = resp.getOutputStream();
        String outputVerifyImage = VerifyCodeUtil.outputVerifyImage(100, 50, outputStream, 4);
        System.out.println(outputVerifyImage);
    }
}
