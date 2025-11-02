package com.codeforall.online.javabank.domain;

import com.codeforall.online.javabank.domain.account.Account;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(JUnitParamsRunner.class)
public class CustomerTest {

    // SUT
    private Customer customer;

    @Before
    public void setUp(){
        customer = new Customer();
    }

    @Test
    @Parameters({"0"})
    public void testInitialBalance(int expectedBalance){
        assertEquals(expectedBalance, customer.getTotalBalance(), 0.1);
    }

    @Test
    @Parameters({"100"})
    public void testGetTotalBalance(double balance) {
        // Set Up
        Account mockAccount1 = mock(Account.class);
        Account mockAccount2 = mock(Account.class);

        when(mockAccount1.getBalance()).thenReturn(balance);
        when(mockAccount2.getBalance()).thenReturn(balance);

        assertEquals(balance, mockAccount1.getBalance(), 0);
        assertEquals(balance, mockAccount2.getBalance(), 0);

        customer.addAccount(mockAccount1);
        customer.addAccount(mockAccount2);

        // Exercise and Verify
        assertEquals(balance + balance, customer.getTotalBalance(), 0.1);
    }

    @Test
    @Parameters({"1, 0"})
    public void testAddAccount(int expectedListSize, int index) {
        // Set Up
        Account account = mock(Account.class);

        // Exercise
        customer.addAccount(account);

        // Verify
        assertEquals(expectedListSize, customer.getAccounts().size());
        assertEquals(account, customer.getAccounts().get(index));
    }
}
