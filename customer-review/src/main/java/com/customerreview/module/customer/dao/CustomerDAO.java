package com.customerreview.module.customer.dao;

import com.customerreview.module.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends CrudRepository<Customer,Integer> {
}
