package com.example.hometask3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "Questionnaire with answers", value = "/output")
public class QuestServlet extends HttpServlet {
    private String valueOfQuestion1;
    private String valueOfQuestion2;

    private String[] listQuestions = new String[2];
    private List<List> listAnswers = new ArrayList<>();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String newURL = "http://localhost:8086/";
        String redirectURL = response.encodeRedirectURL(newURL);

        listQuestions[0] = "1. Do you like Java?";
        listQuestions[1] = "2. Do you like Python?";



        if (valueOfQuestion1 == null || valueOfQuestion2 == null) {
            response.sendRedirect(redirectURL);
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><head><title>Your Answers</title></head>");
                out.println("<body><table border=2\">");
                for (int i = 0; i < listQuestions.length; i++) {
                    out.println("<tr><td>" + listQuestions[i] + "</td>");
                    out.println("<td>" + listAnswers.get(i).get(i) + "</td></tr>");
                }
                out.println("</table><br>");
                out.println("<a href=\"http://localhost:8086/\">Return to questionnaire</a>");
                out.println("</body></html>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String newURL = "http://localhost:8086/";
        String redirectURL = response.encodeRedirectURL(newURL);

        valueOfQuestion1 = request.getParameter("ques1");
        valueOfQuestion2 = request.getParameter("ques2");

        List<String> outputToTable = new ArrayList<>();
        outputToTable.add(valueOfQuestion1);
        outputToTable.add(valueOfQuestion2);


        if (valueOfQuestion1 == null || valueOfQuestion2 == null) {
            response.sendRedirect(redirectURL);
        } else {
            for (int i = 0; i < outputToTable.size(); i++) {
                listAnswers.add(i, outputToTable);
            }
            response.sendRedirect("/output");
        }

    }
}