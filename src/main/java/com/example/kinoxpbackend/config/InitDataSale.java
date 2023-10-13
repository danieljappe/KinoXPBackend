package com.example.kinoxpbackend.config;

import com.example.kinoxpbackend.model.SaleItem;
import com.example.kinoxpbackend.repositoryAllSale.SaleDetailRepository;
import com.example.kinoxpbackend.repositoryAllSale.SaleItemRepository;
import com.example.kinoxpbackend.repositoryAllSale.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        SaleItem saleItem3 = new SaleItem();
        SaleItem saleItem4 = new SaleItem();
        SaleItem saleItem5 = new SaleItem();
        SaleItem saleItem6 = new SaleItem();
        SaleItem saleItem7 = new SaleItem();
        SaleItem saleItem8 = new SaleItem();
        SaleItem saleItem9 = new SaleItem();

        saleItem.setSaleItemName("Water");
        saleItem.setSaleItemPrice(2);
        saleItem2.setSaleItemName("Colo");
        saleItem2.setSaleItemPrice(2);
        saleItem3.setSaleItemName("Fanta");
        saleItem3.setSaleItemPrice(2);

        saleItem4.setSaleItemName("popcorn Small");
        saleItem4.setSaleItemPrice(5);
        saleItem5.setSaleItemName("Popcorn big");
        saleItem5.setSaleItemPrice(10);
        saleItem6.setSaleItemName("Haribo Bag");
        saleItem6.setSaleItemPrice(5);
        saleItem7.setSaleItemName("nachos");
        saleItem7.setSaleItemPrice(10);
        saleItem8.setSaleItemName("Chips");
        saleItem8.setSaleItemPrice(20);
        saleItem9.setSaleItemName("candy 100 gram");
        saleItem9.setSaleItemPrice(1);

        saleItemRepository.save(saleItem);
        saleItemRepository.save(saleItem2);
        saleItemRepository.save(saleItem3);
        saleItemRepository.save(saleItem4);
        saleItemRepository.save(saleItem5);
        saleItemRepository.save(saleItem6);
        saleItemRepository.save(saleItem7);
        saleItemRepository.save(saleItem8);


      /*  Sale sale = new Sale();
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

       */
    }
}
