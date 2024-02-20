package com.example.admissionweb;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String en_email=request.getParameter("email");
        String en_password =request.getParameter("password");
        //now sessions

        HttpSession session=request.getSession();
        String email_data = (String) session.getAttribute("email1");
        String Password_data= (String) session.getAttribute("password1");

        if(en_email.equals(email_data)&&en_password.equals(Password_data)) {
            EmailServlet emailServlet = new EmailServlet();
            emailServlet.sendEmail(en_email);
//           EmailServlet.sendEmail(en_email);

            //response.sendRedirect("newStudent.jsp");
            RequestDispatcher dispatcher = request.getRequestDispatcher("newStudent.jsp");
            dispatcher.forward(request, response);

        }
        else {
            request.setAttribute("result","check well your user name or password");
            RequestDispatcher dispatcher= request.getRequestDispatcher("Login.jsp");
        }



    }
}
