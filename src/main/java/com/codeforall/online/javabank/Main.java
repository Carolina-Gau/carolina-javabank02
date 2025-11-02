package com.codeforall.online.javabank;

import com.codeforall.online.javabank.domain.Bank;
import com.codeforall.online.javabank.domain.Customer;
import com.codeforall.online.javabank.domain.account.AccountType;
import com.codeforall.online.javabank.exceptions.CustomerNotFoundException;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer c1 = new Customer();
        Customer c2 = new Customer();
        Customer c3 = new Customer();

        c1.setId(bank.getNextCustomerId());
        c1.setFirstName("João");
        c1.setLastName("Oliveira");
        c1.setEmail("oliveira@gmail.com");
        c1.setPhone("919888777");

        c2.setId(bank.getNextCustomerId());
        c2.setFirstName("João");
        c2.setLastName("Townsend");
        c2.setEmail("townsend@gmail.com");
        c2.setPhone("916555444");

        c3.setId(bank.getNextCustomerId());
        c3.setFirstName("Sara");
        c3.setLastName("Lopes");
        c3.setEmail("lopes@gmail.com");
        c3.setPhone("913222111");


        bank.getCustomers().put(c1.getId(), c1);
        bank.getCustomers().put(c2.getId(), c2);
        bank.getCustomers().put(c3.getId(), c3);

        try {
            bank.openAccount(AccountType.CHECKING, c1.getId(), 300);
            bank.openAccount(AccountType.SAVINGS, c1.getId(), 1000);
            bank.openAccount(AccountType.CHECKING, c2.getId(), 250);

        } catch (CustomerNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
