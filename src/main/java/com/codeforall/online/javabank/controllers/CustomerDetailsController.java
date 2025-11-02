package com.codeforall.online.javabank.controllers;

import com.codeforall.online.javabank.domain.Customer;
import com.codeforall.online.javabank.model.TheOneWhoKnowsAllCustomers;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class CustomerDetailsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TheOneWhoKnowsAllCustomers theOneWhoKnowsAllCustomers = TheOneWhoKnowsAllCustomers.getInstance();

        String id = (String) getServletContext().getAttribute("id");
        Customer customer = theOneWhoKnowsAllCustomers.getCustomerId(Integer.parseInt(id));

        request.setAttribute("customer", customer);

        request.getRequestDispatcher("/template/details.jsp").forward(request, response);

    }
}
