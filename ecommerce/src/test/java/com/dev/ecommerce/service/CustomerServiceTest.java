package com.dev.ecommerce.service;
import com.dev.ecommerce.exception.CustomerNotFoundException;
import com.dev.ecommerce.model.Customer;
import com.dev.ecommerce.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;


    @BeforeEach
    public void setUp(){
        customerRepository = Mockito.mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepository);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = new Customer((long) 1, "ali","ali@gmail.com","23423432");
        Mockito.when(customerRepository.findById((long)1)).thenReturn(Optional.of(customer));

        Customer result = customerService.findCustomerById((long)1);

        Assertions.assertEquals(result, customer);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdNotExists_shouldReturnCustomerNotFoundException(){
        Mockito.when(customerRepository.findById((long)1)).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomerNotFoundException.class, () -> customerService.findCustomerById((long)1));

    }

    @Test
    public void testFindAllCustomers_shouldReturnCustomerList(){
        List<Customer> newCustomers = new ArrayList<>();

        Customer customer1= new Customer((long)1,"ayse","ayse@gmail.com","21321231");
        Customer customer2= new Customer((long)2,"hasan","hasan@gmail.com","2121232");
        Customer customer3= new Customer((long)3,"berk","berk@gmail.com","21321233");

        newCustomers.add(customer1);
        newCustomers.add(customer2);
        newCustomers.add(customer3);

        Mockito.when(customerRepository.findAll()).thenReturn(newCustomers);

        List<Customer> customers = customerService.findAllCustomers();
        Assertions.assertEquals(newCustomers, customers);
    }

    @Test
    public void whenCreateCustomerCalledWithValidRequest_itShouldReturnValidCustomer(){
        Customer customer = new Customer((long) 1, "ali","ali@gmail.com","23423432");

        Mockito.when(customerRepository.save(customer)).thenReturn(customer);

        Customer result = customerService.saveCustomer(customer);

        Assertions.assertEquals(customer, result);

    }


}