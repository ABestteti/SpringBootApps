package com.luv2code.springboot.crudedemo.dao;

import com.luv2code.springboot.crudedemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    // define field for entityManager
    private EntityManager entityManager;

    // set up constructor for injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        // execute the query and get the result list
        List<Employee> employees = theQuery.getResultList();

        // return the result list
        return employees;
    }
    @Override
    public Employee findById(int theId) {

        //get and return the empployee
        return entityManager.find(Employee.class, theId);
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save employee
        Employee employee = entityManager.merge(theEmployee);

        // return the employee
        return employee;
    }

    @Override
    public void deleteById(int theId) {
        // find the employee by id
        Employee employee = entityManager.find(Employee.class, theId);

        // remove/delete the employee from the database.
        entityManager.remove(employee);
    }
}
