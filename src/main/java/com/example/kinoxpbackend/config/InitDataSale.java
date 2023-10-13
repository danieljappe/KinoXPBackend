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
    SaleDetailRepository saleDetailRepository;

    private final SaleItemRepository saleItemRepository;

    public InitDataSale(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    @Override
    public void run(String... args) {
        SaleItem saleItem = new SaleItem("Water bottle", 2, "https://i.pinimg.com/originals/c6/b1/83/c6b183dbdd5e6e76d10fde40212929be.jpg");
        SaleItem saleItem2 = new SaleItem("Coca Cola bottle", 2, "https://as1.ftcdn.net/v2/jpg/02/94/77/04/1000_F_294770424_28McL2coTqDN3kxWDNDLmCHTyl3e1UBu.jpg");
        SaleItem saleItem3 = new SaleItem("Fanta bottle", 2, "https://billigfadoel.dk/wp-content/uploads/2022/10/Fanta-Orange-50-cl-plastikflaske-24-stk-bestil-hos-Billigfadoel.jpg");
        SaleItem saleItem4 = new SaleItem("Popcorn small", 5, "https://roisbros.gr/wp-content/uploads/2019/02/Crepes-and-popcorn-08-scaled.jpg");
        SaleItem saleItem5 = new SaleItem("Popcorn large", 10,"https://img1.cgtrader.com/items/3142576/7c67c715b1/large/popcorn-box-large-3d-model-max-obj-fbx.jpg");
        SaleItem saleItem6 = new SaleItem("Haribo Bag", 5,"https://happycandy.co.uk/cdn/shop/products/haribo-supermix-treat-bag-16g-456281_512x512.jpg?v=1677758045");
        SaleItem saleItem7 = new SaleItem("nachos Plate", 10,"https://seriouseats.com/thmb/YBUAG17xy1nWYGPmFcJKeoODTzk=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/cheese-sauce-for-cheese-fries-and-nachos-hero-01-e6ccf966688c43ec8025cf9a19678423.jpg");
        SaleItem saleItem8 = new SaleItem("crispy Chips", 8,"https://kims.dk/wp-content/uploads/2019/11/Snacks-Chips-Tomat-160g.png");
        SaleItem saleItem9 = new SaleItem("candy 100 gram", 1, "https://cdn.shopify.com/s/files/1/0366/8685/6236/t/56/assets/20220226_125853-1646039889008.jpg?v=1646039898");


        saleItemRepository.save(saleItem);
        saleItemRepository.save(saleItem2);
        saleItemRepository.save(saleItem3);
        saleItemRepository.save(saleItem4);
        saleItemRepository.save(saleItem5);
        saleItemRepository.save(saleItem6);
        saleItemRepository.save(saleItem7);
        saleItemRepository.save(saleItem8);
        saleItemRepository.save(saleItem9);


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
