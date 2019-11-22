package com.customerreview.module.customer.service;

import com.customerreview.module.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    int addCustomer(String name);
    void deleteCustomer(int id);
    void updateCustomer(int id, String name);
    List<Customer> getAllCustomers();

    Customer getCustomer(int id);
}
