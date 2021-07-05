package com.dev.ecommerce.controller;

import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerControler {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping
    ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return new ResponseEntity<Customer>(customerRepository.save(customer), HttpStatus.OK);
    }
    @GetMapping
    ResponseEntity<List<Customer>> getCustomers(){
        return new ResponseEntity<List<Customer>>((List<Customer>) customerRepository.findAll(), HttpStatus.OK);
    }
}
