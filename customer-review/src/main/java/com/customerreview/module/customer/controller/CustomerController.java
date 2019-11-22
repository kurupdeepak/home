package com.customerreview.module.controller;

import com.customerreview.module.customer.model.Customer;
import com.customerreview.module.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @PutMapping()
    public int add(@RequestBody String customer){
        return customerService.addCustomer(customer);
    }

    @PostMapping("/{id}")
    public int update(@RequestBody String customer,@PathVariable int id){
        customerService.updateCustomer(id,customer);
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable int id){
        customerService.deleteCustomer(id);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }
}
