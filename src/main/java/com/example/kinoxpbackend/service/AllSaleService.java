package com.example.kinoxpbackend.service;

import com.example.kinoxpbackend.dtoSale.SaleConverter;
import com.example.kinoxpbackend.dtoSale.SaleDetailConverter;
import com.example.kinoxpbackend.dtoSale.SaleItemConverter;
import com.example.kinoxpbackend.repositoryAllSale.SaleDetailRepository;
import com.example.kinoxpbackend.repositoryAllSale.SaleItemRepository;
import com.example.kinoxpbackend.repositoryAllSale.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllSaleService {


    @Autowired
    SaleItemRepository saleItemRepository;

    @Autowired
    SaleDetailRepository saleDetailRepository;

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SaleItemConverter saleItemConverter;

    @Autowired
    SaleDetailConverter saleDetailConverter;

    @Autowired
    SaleConverter saleConverter;




/*
    public EmployeeDTO save(EmployeePasswordDTO employeePasswordDTO) {
        Employee employee = employeePasswordConverter.toEntity(employeePasswordDTO);
        employeeRepository.save(employee);
        return employeeConverter.toDTO(employee);
    }

 */

}
