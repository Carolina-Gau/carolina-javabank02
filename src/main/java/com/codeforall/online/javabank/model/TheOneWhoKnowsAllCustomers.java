package com.codeforall.online.javabank.model;

import com.codeforall.online.javabank.domain.Customer;

import java.util.HashMap;
import java.util.Map;

public class TheOneWhoKnowsAllCustomers {
    private Map<Integer, Customer> customers;

    private static TheOneWhoKnowsAllCustomers INSTANCE;

    private TheOneWhoKnowsAllCustomers() {
        customers = HashMap.newHashMap();
        createCustomer();

    }


    private void createCustomer() {
        Customer João = new Customer();
        João.setId(1);
        João.setFirstName("João");
        João.setLastName("Oliveira");
        João.setPhone("911555666");
        João.setEmail("oliveira@gmail.com");
        João.getTotalBalance();
        João.setAccounts();

        Customer Townsend = new Customer();
        Townsend.setId(1);
        Townsend.setFirstName("João");
        Townsend.setLastName("Oliveira");
        Townsend.setPhone("919191919");
        Townsend.setEmail("townsend@gmail.com");
        Townsend.getTotalBalance();
        Townsend.setAccounts();

        Customer Sara = new Customer();
        Sara.setId(1);
        Sara.setFirstName("João");
        Sara.setLastName("Oliveira");
        Sara.setPhone("912288999");
        Sara.setEmail("SAra@gmail.com");
        Sara.getTotalBalance();
        Sara.setAccounts();
    }

    public Customer getCustomerId(Integer id) {
        return customers.get(id);
    }

    public static TheOneWhoKnowsAllCustomers getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new TheOneWhoKnowsAllCustomers();
        }
        return INSTANCE; //garante que apenas existe uma instância dentro de toda a aplicação = só existe lista com todos os clientes, para questões de segurança
    }

    //quando se cria uma conta (submit/save) usa-se o método doPost
}
