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
    public void run(String... args) throws Exception {
        SaleItem saleItem = new SaleItem();
        saleItem.setSaleItemName("popcorn");
        saleItem.setSaleItemPrice(10);

        saleItemRepository.save(saleItem);

        Sale sale = new Sale();
        sale.setSaleDate(new Date());
        sale.setCustomerPhone(60482099);

        saleRepository.save(sale);

        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSale(sale);
        saleDetail.setSaleItem(saleItem);

        saleDetailRepository.save(saleDetail);



    }


}
