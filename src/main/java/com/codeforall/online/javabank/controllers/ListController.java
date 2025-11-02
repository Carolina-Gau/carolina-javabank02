package com.codeforall.online.javabank.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class ListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("templates/index.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String IdParameter = request.getParameter("ID");

        getServletContext().setAttribute("id", IdParameter); //guardar o estado do pedido

        response.sendRedirect("/javabank-step02-carolina/details"); //direcionar para outro servlet depois do doPost

    }
}