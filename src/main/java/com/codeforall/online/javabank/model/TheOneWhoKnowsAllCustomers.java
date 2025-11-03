package com.codeforall.online.javabank.model;

import com.codeforall.online.javabank.domain.Customer;
import com.codeforall.online.javabank.domain.account.CheckingAccount;
import com.codeforall.online.javabank.domain.account.SavingsAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheOneWhoKnowsAllCustomers {
    private Map<Integer, Customer> customers;

    private static TheOneWhoKnowsAllCustomers INSTANCE;

    private TheOneWhoKnowsAllCustomers() {
        customers = new HashMap<>();
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
        João.setAccounts(List.of(
                new CheckingAccount("PT50-0000-1111", 300.0),
                new SavingsAccount("PT50-1111-2222", 1000.0)
        ));

        Customer Townsend = new Customer();
        Townsend.setId(1);
        Townsend.setFirstName("João");
        Townsend.setLastName("Oliveira");
        Townsend.setPhone("919191919");
        Townsend.setEmail("townsend@gmail.com");
        Townsend.getTotalBalance();
        Townsend.setAccounts(List.of(
                new CheckingAccount("PT50-2222-3333", 250.0)
        ));

        Customer Sara = new Customer();
        Sara.setId(1);
        Sara.setFirstName("João");
        Sara.setLastName("Oliveira");
        Sara.setPhone("912288999");
        Sara.setEmail("Sara@gmail.com");
        Sara.getTotalBalance();
        Sara.setAccounts(List.of());
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
