package com.codeforall.online.javabank.factories;

import com.codeforall.online.javabank.domain.account.CheckingAccount;
import com.codeforall.online.javabank.domain.account.Account;
import com.codeforall.online.javabank.domain.account.AccountType;
import com.codeforall.online.javabank.domain.account.SavingsAccount;

/**
 * A factory for creating accounts of different types
 */
public class AccountFactory {

    /**
     * Creates a new {@link Account}
     *
     * @param accountType the account type
     * @return the new account
     */
    public Account createAccount(AccountType accountType) {

        Account newAccount;
        switch (accountType) {
            case CHECKING:
                newAccount = new CheckingAccount();
                break;
            case SAVINGS:
                newAccount = new SavingsAccount();
                break;
            default:
                throw new IllegalArgumentException();
        }

        return newAccount;
    }
}
