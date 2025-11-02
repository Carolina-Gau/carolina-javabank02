package com.codeforall.online.javabank.factories;

import com.codeforall.online.javabank.domain.account.Account;
import com.codeforall.online.javabank.domain.account.AccountType;
import com.codeforall.online.javabank.domain.account.CheckingAccount;
import com.codeforall.online.javabank.domain.account.SavingsAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountFactoryTest {

    // SUT
    private AccountFactory accountFactory;

    @Before
    public void setUp() {
        accountFactory = new AccountFactory();
    }

    @Test
    public void testCreateCheckingAccount() {
        // Exercise
        Account account = accountFactory.createAccount(AccountType.CHECKING);

        // Verify
        assertNotNull(account);
        assertTrue(account instanceof CheckingAccount);
    }

    @Test
    public void testCreateSavingsAccount() {
        // Exercise
        Account account = accountFactory.createAccount(AccountType.SAVINGS);

        // Verify
        assertNotNull(account);
        assertTrue(account instanceof SavingsAccount);
    }
}
