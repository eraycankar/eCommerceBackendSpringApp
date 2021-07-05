package com.dev.ecommerce.service;

import com.dev.ecommerce.exception.CustomerNotFoundException;
import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow( () -> new CustomerNotFoundException("Customer could not find by id: "+id));
    }

}
