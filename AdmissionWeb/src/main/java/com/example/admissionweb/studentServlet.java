package com.example.admissionweb;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.Properties;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 50)    // 50MB
public class studentServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String fullName = request.getParameter("fullName");
        int age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String year = request.getParameter("year");

        jakarta.servlet.http.Part passportFilePart = request.getPart("passportFile");

        String passportFileName = null;
        try {
            passportFileName = getSubmittedFileName(passportFilePart);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        InputStream passportFileContent = passportFilePart.getInputStream();

        jakarta.servlet.http.Part diplomaFilePart = request.getPart("diplomaFile");
        String diplomaFileName = null;
        try {
            diplomaFileName = getSubmittedFileName(diplomaFilePart);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        InputStream diplomaFileContent = diplomaFilePart.getInputStream();

        saveFile(passportFileName, passportFileContent);
        saveFile(diplomaFileName, diplomaFileContent);


        RequestDispatcher dispatcher = request.getRequestDispatcher("EmailSecond");
        dispatcher.forward(request, response);
    }

    private String getSubmittedFileName(jakarta.servlet.http.Part part) throws MessagingException {
        String header = Arrays.toString(new String[]{part.getHeader("content-disposition")});
        for (String content : header.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private void saveFile(String fileName, InputStream fileContent) throws IOException {
        Path filePath = Paths.get("C:\\Users\\hp\\Desktop\\files\\" + fileName);
        Files.copy(fileContent, filePath, StandardCopyOption.REPLACE_EXISTING);
    }


}
