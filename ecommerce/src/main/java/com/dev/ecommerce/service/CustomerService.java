package com.dev.ecommerce.service;

import com.dev.ecommerce.dto.CustomerDto;
import com.dev.ecommerce.dto.CustomerMapper;
import com.dev.ecommerce.exception.CustomerNotFoundException;
import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDto> findAllCustomers(){
        return customerMapper.toListCustomerDto(customerRepository.findAll());
    }

    public CustomerDto findCustomerById(Long id){
        return customerMapper.toCustomerDto(customerRepository.findById(id).orElseThrow( () -> new CustomerNotFoundException("Customer could not find by id:"+id)));
    }

    public CustomerDto saveCustomer(Customer customer){
        return customerMapper.toCustomerDto(customerRepository.save(customer));
    }

 /*   public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }*/


}
