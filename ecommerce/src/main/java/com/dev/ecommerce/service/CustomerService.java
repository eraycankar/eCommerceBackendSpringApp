package com.dev.ecommerce.service;

import com.dev.ecommerce.exception.CustomerNotFoundException;
import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow( () -> new CustomerNotFoundException("Customer could not find by id:"+id));
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

}
