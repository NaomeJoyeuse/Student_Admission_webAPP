package com.example.admissionweb;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fullName =request.getParameter("fullName");
        String email=request.getParameter("email");
        String password =request.getParameter("password");
        HttpSession session = request.getSession();
        session.setAttribute("email1", email);
        session.setAttribute("password1", password);
        response.sendRedirect("Login.jsp");
    }

}
