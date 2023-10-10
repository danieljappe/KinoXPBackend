package com.example.kinoxpbackend.config;

import com.example.kinoxpbackend.model.Sale;
import com.example.kinoxpbackend.model.SaleDetail;
import com.example.kinoxpbackend.model.SaleItem;
import com.example.kinoxpbackend.repositoryAllSale.SaleDetailRepository;
import com.example.kinoxpbackend.repositoryAllSale.SaleItemRepository;
import com.example.kinoxpbackend.repositoryAllSale.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplicationExtensionsKt;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class InitDataSale implements CommandLineRunner {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    SaleItemRepository saleItemRepository;

    @Autowired
    SaleDetailRepository saleDetailRepository;

    @Override
    public void run(String... args) {
        SaleItem saleItem = new SaleItem();
        SaleItem saleItem2 = new SaleItem();
        saleItem.setSaleItemName("popcorn");
        saleItem.setSaleItemPrice(10);

        saleItem2.setSaleItemName("Colo");
        saleItem2.setSaleItemPrice(5);

        saleItemRepository.save(saleItem);

        saleItemRepository.save(saleItem2);

        Sale sale = new Sale();
        Sale sale2 = new Sale();

        sale.setSaleDate(new Date(111101));
        sale2.setSaleDate(new Date(220101));

        sale.setCustomerPhone(60482099);
        sale2.setCustomerPhone(12345678);

        saleRepository.save(sale);
        saleRepository.save(sale2);

        SaleDetail saleDetail = new SaleDetail();
        SaleDetail saleDetail2 = new SaleDetail();

        saleDetail.setSale(sale);
        saleDetail.setSaleItem(saleItem);

        saleDetail2.setSale(sale2);
        saleDetail2.setSaleItem(saleItem2);

        saleDetailRepository.save(saleDetail);
        saleDetailRepository.save(saleDetail2);
    }
}
