package com.dev.ecommerce.controller;

import com.dev.ecommerce.dto.CreateCustomerRequest;
import com.dev.ecommerce.dto.CreateCustomerRequestMapper;
import com.dev.ecommerce.dto.CustomerDto;
import com.dev.ecommerce.dto.CustomerMapper;
import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {


    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final CreateCustomerRequestMapper createCustomerRequestMapper;


    public CustomerController(CustomerService customerService, CustomerMapper customerMapper, CreateCustomerRequestMapper createCustomerRequestMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.createCustomerRequestMapper = createCustomerRequestMapper;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> findAllCustomers(){
        return ResponseEntity.ok(customerMapper.toListCustomerDto(customerService.findAllCustomers()));
    }

    @PostMapping
    public ResponseEntity<CreateCustomerRequest> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest){
        customerService.saveCustomer(createCustomerRequestMapper.convertToCustomer(createCustomerRequest));

        return ResponseEntity.status(HttpStatus.CREATED).body(createCustomerRequest);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable Long id){
        Optional<CustomerDto> customer = Optional.ofNullable(customerMapper.toCustomerDto(customerService.findCustomerById(id)));
        return ResponseEntity.ok(customer.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto){
        Customer customer = customerMapper.toCustomer(customerDto);
        customer.setId(id);
        customerService.saveCustomer(customer);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerDto);
    }

}
