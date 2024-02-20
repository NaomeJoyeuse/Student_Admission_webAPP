// Import statements
package com.example.admissionweb;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;
@WebServlet("/EmailSecond")
public class EmailSecond extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        sendEmail(fullName, email, course);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Admissionsdata.jsp");
        dispatcher.forward(request, response);
    }

    public void sendEmail(String fullName, String email, String course) {
       // my email details
        String host = "smtp.gmail.com";
        String username = "kanyananaome5@gmail.com";
        String password = "zjuv aqoo jazv hlwc";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Admission  Submission Confirmation");
            message.setText("Dear " + fullName + ",\n\n"
                    + "Thank you for submitting the admission form. Your application for the course '"
                    + course + "' has been received.\n\n"
                    + "Best regards,\nAUCA");

            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
