package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.dto.dtoCustomer.CustomerConverter;
import com.example.kinoxpbackend.dto.dtoCustomer.CustomerDTO;
import com.example.kinoxpbackend.model.Customer;
import com.example.kinoxpbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerConverter customerConverter;


    public CustomerDTO postCustomer(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setCustomerPhone(customerDTO.customerPhone());

        Optional<Customer> optC1 = customerRepository.findById(customerDTO.customerPhone());
        if (optC1.isPresent()){
            return customerConverter.toDTO(optC1.get());
        }else{
            customerRepository.save(customer);
            return customerConverter.toDTO(customer);
        }

    }



}
