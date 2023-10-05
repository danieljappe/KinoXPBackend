package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.model.Customer;
import com.example.kinoxpbackend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerByPhone(String customer_phone){

        Optional<Customer> c1= customerRepository.findById(customer_phone);
        if (c1.isPresent()){
            return c1.get();
        }else {
            throw new RuntimeException("something went wrong");
        }
    }


}
