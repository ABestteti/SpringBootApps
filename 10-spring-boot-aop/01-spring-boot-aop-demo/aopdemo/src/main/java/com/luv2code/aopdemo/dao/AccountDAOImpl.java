package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {
    System.out.println(getClass() + " Running AccountDOA addAccount() method...\n\n");
    }
}
