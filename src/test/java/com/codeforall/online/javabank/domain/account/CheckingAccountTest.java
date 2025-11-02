package com.codeforall.online.javabank.domain.account;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class CheckingAccountTest {

    // SUT
    private CheckingAccount account;

    @Before
    public void setUp() {
        account = new CheckingAccount();
    }

    @Test
    public void testGetAccountType() {
        // Exercise and Verify
        assertEquals(AccountType.CHECKING, account.getAccountType());
    }

    @Test
    @Parameters({"0"})
    public void testInitialBalance(double expectedInitialBalance) {
        // Exercise and Verify
        assertEquals(expectedInitialBalance, account.getBalance(), 0.1);
    }


    @Test
    @Parameters({"100"})
    public void testCredit(double amount) {
        // Set Up
        double balance = account.getBalance();

        // Exercise
        account.credit(amount);

        // Verify
        assertEquals(balance + amount, account.getBalance(), 0.1);
    }

    @Test
    @Parameters({"-100"})
    public void testCreditNegativeValue(double amount) {
        // Set Up
        double balance = account.getBalance();

        // Exercise
        account.credit(amount);

        // Verify
        assertEquals(balance, account.getBalance(), 0);
    }

    @Test
    @Parameters({"200, 100"})
    public void testDebit(double amountToCredit, int amountToDebit) {
        // Set Up
        double initialBalance = account.getBalance();

        account.credit(amountToCredit);
        assertEquals(amountToCredit + initialBalance, account.getBalance(), 0);

        // Exercise
        account.debit(amountToDebit);

        // Verify
        assertEquals(amountToCredit + initialBalance - amountToDebit, account.getBalance(), 0);
    }

    @Test
    @Parameters({"100, 300"})
    public void testDebitFail(double amountToCredit,int amountToDebit) {
        // Set Up
        double initialBalance = account.getBalance();

        account.credit(amountToCredit);
        assertEquals(amountToCredit + initialBalance, account.getBalance(), 0);

        // Exercise
        account.debit(amountToDebit);

        // Verify
        assertEquals(amountToCredit + initialBalance, account.getBalance(), 0);
    }

    @Test
    @Parameters({"-100"})
    public void testDebitNegativeValue(double amount) {
        // Set Up
        double balance = account.getBalance();

        // Exercise
        account.debit(amount);

        // Verify
        assertEquals(balance, account.getBalance(), 0);
    }

    @Test
    @Parameters({"100"})
    public void testCanCredit(double amount) {
        // Exercise and Verify
        assertTrue(account.canCredit(amount));
    }

    @Test
    @Parameters({"-100"})
    public void testCantCredit(double amount) {
        // Exercise and Verify
        assertFalse(account.canCredit(amount));
    }

    @Test
    @Parameters({"100"})
    public void testCanDebit(int amount) {
        // Set Up
        account.credit(amount);

        // Exercise and Verify
        assertTrue(account.canDebit(amount));
    }

    @Test
    @Parameters({"-100"})
    public void testCantDebitNegativeAmount(int amount) {
        // Set Up
        account.credit(amount);

        // Exercise and Verify
        assertFalse(account.canDebit(amount));
    }

    @Test
    @Parameters({"50, 100"})
    public void testCantLeaveAnAccountWithNegativeBalance(int amountToCredit, int amountToDebit) {
        // Set Up
        account.credit(amountToCredit);

        // Exercise and Verify
        assertFalse(account.canDebit(amountToDebit));
    }

    @Test
    public void testCanWithdraw() {
        // Exercise and Verify
        assertTrue(account.canWithdraw());
    }
}
