package com.example.demo.servlet;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/user/login")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
//        System.out.println("name = " + name + " pass = " + password);

        User loggedUser = userService.login(name, password);
        if (loggedUser != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("demo_user", loggedUser);
//          校验通过后，重定向
            resp.sendRedirect(req.getContextPath() + "/brand");

        } else {
//            req.setAttribute("login_msg", "logged error");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User loggedUser = userService.login(name, password);
        if (loggedUser != null) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("logged_user", loggedUser);
            resp.sendRedirect(req.getContextPath() + "/brand");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
