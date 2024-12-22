package vn.edu.hcmuaf.fit.lab6_login.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import vn.edu.hcmuaf.fit.lab6_login.services.AuthServices;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        out.println("<p>Username: " + username +"</p>");
//        out.println("<p>Password: " + password +"</p>");
        AuthServices authServices = new AuthServices();
        if (authServices.checkLogin(username, password)) { // login thành công chuyển tới index
            response.sendRedirect("index.jsp");
        }else { // ko thành công quay lại login
            request.setAttribute("error", "Dang nhap khong thanh cong"); // thông báo lỗi
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}