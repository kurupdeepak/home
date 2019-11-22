package com.customer.service;

import com.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    int addCustomer(String name);
    int deleteCustomer(int id);
    int updateCustomer(Customer customer);
    List<Customer> getAllCustomers();
}
