package com.codeforall.online.javabank.domain;

import com.codeforall.online.javabank.domain.account.Account;
import com.codeforall.online.javabank.domain.account.AccountType;
import com.codeforall.online.javabank.domain.account.CheckingAccount;
import com.codeforall.online.javabank.domain.account.SavingsAccount;
import com.codeforall.online.javabank.exceptions.CustomerNotFoundException;
import com.codeforall.online.javabank.factories.AccountFactory;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class BankTest {

    // SUT
    private Bank bank;

    // DOCs
    private Map<Integer,Customer> customers;
    private AccountFactory accountFactory;

    private Customer customer;

    @Before
    public void setUp(){
        this.bank = new Bank();

        customers = new HashMap<>();
        accountFactory = mock(AccountFactory.class);
        bank.setAccountFactory(accountFactory);

        customer = mock(Customer.class);
        int mockCustomerId = 1;
        when(customer.getId()).thenReturn(mockCustomerId);

        customers.put(customer.getId(), customer);
        bank.setCustomers(customers);
    }

    @Test
    public void testGetCustomersList(){
        // Set Up
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        // Exercise and Verify
        assertEquals(customerList, bank.getCustomersList());
    }

    @Test
    @Parameters({"1"})
    public void testGetCustomer(Integer id) throws CustomerNotFoundException {
        // Exercise and Verify
        assertEquals(customer, bank.getCustomer(id));
    }

    @Test(expected = CustomerNotFoundException.class)
    @Parameters({"100"})
    public void testGetCustomerThrowsCustomerNotFoundException(Integer id) throws CustomerNotFoundException {
        // Exercise and Verify
        bank.getCustomer(id);
    }

    /*
    //Another way, using assertThrows(), available since JUnit 4.13
    @Test
    @Parameters({"100"})
    public void testGetCustomerThrowsCustomerNotFoundException(Integer id) {
        assertThrows(CustomerNotFoundException.class, () -> bank.getCustomer(id));
    }
    */

    @Test
    @Parameters({"100.0"})
    public void testOpenAccount(double balance) throws CustomerNotFoundException {
        // Set Up
        Account account = mock(CheckingAccount.class);
        when(accountFactory.createAccount(AccountType.CHECKING)).thenReturn(account);

        // Exercise
        bank.openAccount(AccountType.CHECKING, customer.getId(), balance);

        // Verify
        verify(accountFactory).createAccount(AccountType.CHECKING);
        verify(account, times(1)).credit(balance);
        verify(account, times(1)).setId(customer.getId());
        verify(bank.getCustomer(customer.getId())).addAccount(account);
    }

    @Test(expected = CustomerNotFoundException.class)
    @Parameters({"100.0, 100"})
    public void testOpenAccountThrowsCustomerNotFoundException(double balance, int nonCustomerId) throws CustomerNotFoundException {
        // Set Up
        Account account = mock(CheckingAccount.class);
        when(accountFactory.createAccount(AccountType.CHECKING)).thenReturn(account);

        // Exercise and Verify
        bank.openAccount(AccountType.CHECKING, nonCustomerId, balance);
    }

/*
    // Another way with assertThrows()
    @Test
    @Parameters({"100.0, 100"})
    public void testOpenAccountThrowsCustomerNotFoundException(double balance, int nonCustomerId) {
        // Set Up
        Account account = mock(CheckingAccount.class);
        when(accountFactory.createAccount(AccountType.CHECKING)).thenReturn(account);

        // Exercise and Verify
        assertThrows(CustomerNotFoundException.class, () -> bank.openAccount(AccountType.CHECKING, nonCustomerId, balance));
        verify(customer, never()).addAccount(account);
    }
*/

    @Test
    @Parameters({"100.0"})
    public void testOpenSavingsAccountWithMinBalance(double balance) throws CustomerNotFoundException {
        // Set Up
        SavingsAccount account = mock(SavingsAccount.class);
        when(accountFactory.createAccount(AccountType.SAVINGS)).thenReturn(account);

        // Exercise
        bank.openAccount(AccountType.SAVINGS, customer.getId(), balance);

        verify(accountFactory).createAccount(AccountType.SAVINGS);
        verify(account, times(1)).credit(balance);
        verify(account, times(1)).setId(customer.getId());
        verify(bank.getCustomer(customer.getId())).addAccount(account);
    }

    @Test
    @Parameters({"0.0"})
    public void testOpenSavingsAccountWithoutMinBalance(double balance) throws CustomerNotFoundException {
        // Set Up
        SavingsAccount account = mock(SavingsAccount.class);
        when(accountFactory.createAccount(AccountType.SAVINGS)).thenReturn(account);

        // Exercise
        bank.openAccount(AccountType.SAVINGS, customer.getId(), balance);

        verifyNoInteractions(accountFactory);
        verifyNoInteractions(account);
        verify(bank.getCustomer(customer.getId()), never()).addAccount(account);
    }

    @Test
    @Parameters({"1"})
    public void testCustomerExists(Integer id) {
        // Exercise and Verify
        assertTrue(bank.customerExists(id));
    }

    @Test
    @Parameters({"100"})
    public void testCustomerDoesntExist(Integer id) {
        // Exercise and Verify
        assertFalse(bank.customerExists(id));
    }

    @Test
    @Parameters({"0, 1"})
    public void testAddCustomer(int initialSize, int customerListSize) throws CustomerNotFoundException {
        // Set Up
        customers.clear();
        assertEquals(initialSize, customers.size());

        // Exercise
        bank.addCustomer(customer);

        // Verify
        assertEquals(customerListSize, bank.getCustomersList().size());
        assertEquals(customer, bank.getCustomer(customer.getId()));
    }
}
