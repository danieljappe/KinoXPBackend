package com.example.kinoxpbackend.dtoCustomer;

import com.example.kinoxpbackend.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {


    public CustomerDTO toDTO(Customer customer){
        return new CustomerDTO(customer.getCustomerPhone());
    }

}
