package com.example.admissionweb;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.Filter;

public class FilterAuth implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//        //get the current session
//        HttpSession session = httpRequest.getSession(false);
//        boolean isLoginPage = httpRequest.getRequestURI().endsWith("Login.jsp");
//        boolean isAdmissionPage = httpRequest.getRequestURI().contains("newStudent.jsp");
//
//        boolean isLoggedIn = session != null && session.getAttribute("email") != null;
//        if (isLoginPage || isAdmissionPage || isLoggedIn) {
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            // if not logged in, redirect to the login page
//            httpResponse.sendRedirect("Login.jsp");
//        }
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("email") != null);
        if (!isLoggedIn && (httpRequest.getRequestURI().endsWith("newStudent.jsp") || httpRequest.getRequestURI().endsWith("Admissionsdata.jsp"))) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login.jsp");
            return;
        }
        chain.doFilter(request, response);
    }





}
