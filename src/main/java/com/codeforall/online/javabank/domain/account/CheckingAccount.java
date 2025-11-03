package com.codeforall.online.javabank.domain.account;

/**
 * A checking account with no restrictions
 * @see Account
 * @see AccountType#CHECKING
 */
public class CheckingAccount extends AbstractAccount {


    public CheckingAccount(String s, double v) {
        super();
    }

    /**
     * @see Account#getAccountType()
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.CHECKING;
    }

}
