package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSillyAccount() {
    System.out.println(getClass() + " Running MembershipDAO addAccount() method...\n\n");
        return true;
    }
}
