package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account theAccount, Boolean vipFlag) {
        System.out.println(getClass() + "Running AccountDOA addAccount() method...\n\n");
    }

    @Override
    public boolean doWork() {
        System.out.println("Running doWork() method...\n\n");
        return false;
    }
}
