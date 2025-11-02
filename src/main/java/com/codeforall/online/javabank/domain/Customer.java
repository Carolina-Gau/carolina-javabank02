package com.codeforall.online.javabank.domain;

import com.codeforall.online.javabank.domain.account.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * A class with represents a customer of the bank
 */
public class Customer {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<Account> accounts;

    public Customer() {
        this.accounts = new ArrayList<>();
    }

    /**
     * Gets the total balance of the accounts associated with the customer
     * @return the total balance
     */
    public double getTotalBalance() {
        double balance = 0;

        for (Account a : accounts) {
            balance += a.getBalance();
        }
        return balance;
    }

    /**
     * Adds an account to the list of account of the customer
     * @param account to add
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }

    /**
     * Gets the id of the customer
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the first name of the customer
     * @return the first name of the customer
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the customer
     * @return the last name of the customer
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the email of the customer
     * @return the email of the customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the phone of the customer
     * @return the phone of the customer
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the list of the accounts associated with the customer
     * @return the list of accounts
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Sets the id of the customer
     * @param id the id of the customer
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Sets the first name of the customer
     * @param firstName the first name of the customer
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the customer
     * @param lastName the last name of the customer
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the email of the customer
     * @param email the first name of the customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the phone of the customer
     * @param phone the phone of the customer
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the accounts associated with the customer
     * @param accounts the accounts to set
     */
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}


