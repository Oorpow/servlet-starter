package com.example.demo.servlet;

import com.example.demo.entity.Brand;
import com.example.demo.service.BrandService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

// servlet 类似controller
// service 主要逻辑实现
// mapper 数据库操作
@WebServlet("/brand")
public class BrandServlet extends HttpServlet {
    private BrandService brandService = new BrandService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brandList = brandService.findAll();
        req.setAttribute("brandList", brandList);
        req.getRequestDispatcher("/brand.jsp").forward(req, resp);
    }
}
