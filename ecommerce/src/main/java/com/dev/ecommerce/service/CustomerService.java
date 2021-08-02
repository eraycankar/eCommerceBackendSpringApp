package com.dev.ecommerce.service;

import com.dev.ecommerce.exception.CustomerNotFoundException;
import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class CustomerService {

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Long id){
        logger.warn("A WARN Message");
        return customerRepository.findById(id).orElseThrow( () -> new CustomerNotFoundException("Customer could not find by id:"+id));
    }

    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

}
