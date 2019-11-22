package com.customerreview.module.customer.service;

import com.customerreview.module.common.service.NotFoundException;
import com.customerreview.module.customer.dao.CustomerDAO;
import com.customerreview.module.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    @Override
    public int addCustomer(String name) {
        Customer c = customerDAO.save(new Customer(name));
        return c.getCustomerId();
    }

    @Override
    public void deleteCustomer(int id) {
        Optional<Customer> c = customerDAO.findById(id);
        if(!c.isPresent())
            throw new NotFoundException("Failed to delete : customer not found " + id);
        customerDAO.delete(c.get());
    }

    @Override
    public void updateCustomer(int id,String name) {
        Optional<Customer> c = customerDAO.findById(id);
        if(!c.isPresent())
            throw new NotFoundException("Failed to delete : customer not found " + id);
        c.get().setName(name);
        customerDAO.save(c.get());
    }

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerDAO.findAll();
    }
}
