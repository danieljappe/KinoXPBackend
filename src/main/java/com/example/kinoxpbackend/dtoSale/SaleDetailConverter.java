package com.example.kinoxpbackend.dtoSale;

import com.example.kinoxpbackend.model.SaleDetail;
import org.springframework.stereotype.Component;

@Component
public class SaleDetailConverter {

    public SaleDetailDTO toDTO(SaleDetail saleDetail) {
        return new SaleDetailDTO(
                saleDetail.getSaleDetailId(),
                saleDetail.getSale(),
                saleDetail.getSaleItem(),
                saleDetail.getQuantity()
        );
    }


    public SaleDetail toEntity(SaleDetailDTO saleDetailDTO) {
        SaleDetail saleDetail = new SaleDetail();
        saleDetail.setSaleDetailId(saleDetailDTO.saleDetailID());
        saleDetail.setSale(saleDetailDTO.sale());
        saleDetail.setSaleItem(saleDetailDTO.saleItem());
        saleDetail.setQuantity(saleDetailDTO.quantity());

        return saleDetail;
    }
}
