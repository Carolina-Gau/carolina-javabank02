package com.codeforall.online.javabank.domain;

import com.codeforall.online.javabank.domain.account.Account;
import com.codeforall.online.javabank.domain.account.AccountType;
import com.codeforall.online.javabank.exceptions.CustomerNotFoundException;
import com.codeforall.online.javabank.factories.AccountFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class which represents the Bank and its activities
 */
public class Bank {

    private Map<Integer,Customer> customers;
    private AccountFactory accountFactory;

    private int nextCustomerId = 0;
    private int nextAccountId = 0;

    public Bank() {
        customers = new HashMap<>();
        accountFactory = new AccountFactory();
    }

    /**
     * Gets a list of the customers of the bank
     * @return a list of customers
     */
    public List<Customer> getCustomersList() {
        return new ArrayList<>(customers.values());
    }

    /**
     * Gets a customer by their id
     * @param id customer id
     * @return the customer
     * @throws CustomerNotFoundException
     */
    public Customer getCustomer(Integer id) throws CustomerNotFoundException {

        if(!customerExists(id)) {
            throw new CustomerNotFoundException();
        }

        return customers.get(id);
    }

    /**
     * Opens an account
     * @param accountType the type of the account to open
     * @param customerId the id of the customer associated with the account
     * @param balance the initial balance of the account
     * @throws CustomerNotFoundException
     */
    public void openAccount(AccountType accountType, Integer customerId, double balance) throws CustomerNotFoundException {
        if(accountType.equals(AccountType.SAVINGS) && balance < 100) {
            return;
        }

        Account account = accountFactory.createAccount(accountType);
        account.credit(balance);
        account.setId(getNextAccountId());

        getCustomer(customerId).addAccount(account);
    }

    /**
     * Check if the customer exists
     * @param id the customer's id
     * @return true if the customer exists
     */
    public boolean customerExists(Integer id) {
        return customers.containsKey(id);
    }

    /**
     * Gets the next customer id
     * @return the next id
     */
    public Integer getNextCustomerId() {
        return ++nextCustomerId;
    }

    /**
     * Gets the next account id
     * @return the next id
     */
    private Integer getNextAccountId() {
        return ++nextAccountId;
    }

    /**
     * Adds a customer to the bank
     * @param customer the customer to add
     */
    public void addCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    /**
     * Gets the map of customers
     * @return a map of customers
     */
    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    /**
     * Sets a map of customers
     * @param customers the map of customers to set
     */
    public void setCustomers(Map<Integer, Customer> customers) {
        this.customers = customers;
    }

    /**
     * Sets an Account Factory to the bank
     * @param accountFactory the account factory to set
     */
    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }
}
