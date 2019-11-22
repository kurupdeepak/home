package com.customerreview.module.customer.dao;

import com.customerreview.module.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerDAO extends CrudRepository<Customer,Integer> {
}
