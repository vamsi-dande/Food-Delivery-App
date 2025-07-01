package com.tap.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.mail.MessagingException;

@WebServlet("/sendEmail")
public class EmailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");

        try {
            EmailUtil.sendEmail(to, subject, body);
            response.getWriter().write("Email sent successfully!");
        } catch (MessagingException e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
