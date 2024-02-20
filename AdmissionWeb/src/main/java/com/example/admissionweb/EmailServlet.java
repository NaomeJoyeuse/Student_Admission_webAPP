package com.example.admissionweb;

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
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {


        public void sendEmail (String email){
            
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
                message.setSubject("Login Authorization");
                message.setText("Dear" +"you have logged in Admission web platform.\n\n"
                        + "\n if its not you please check your account");

                Transport.send(message);

                System.out.println("Email sent successfully!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

