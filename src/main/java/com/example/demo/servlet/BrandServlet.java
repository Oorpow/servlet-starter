package com.example.demo.servlet;

import com.example.demo.Brand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/brand")
public class BrandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Brand> brands = new ArrayList<>();
        brands.add(new Brand(1, "i17", "apple", 50, "", 1));
        brands.add(new Brand(2, "xiaomi16", "xiaomi", 50, "", 1));

        req.setAttribute("brandList", brands);
        req.getRequestDispatcher("/brand.jsp").forward(req, resp);
//        super.doGet(req, resp);
    }
}
