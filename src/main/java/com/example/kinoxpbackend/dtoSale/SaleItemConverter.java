package com.example.kinoxpbackend.dtoSale;

import com.example.kinoxpbackend.model.SaleItem;
import org.springframework.stereotype.Component;

@Component
public class SaleItemConverter {

    public SaleItemDTO toDTO(SaleItem saleItem) {
        return new SaleItemDTO(
                saleItem.getSaleItemId(),
                saleItem.getSaleItemName(),
                saleItem.getSaleItemPrice()
        );
    }

    public SaleItem toEntity(SaleItemDTO saleItemDTO) {
        SaleItem saleItem = new SaleItem();
        saleItem.setSaleItemId(saleItemDTO.saleItemId());
        saleItem.setSaleItemName(saleItemDTO.saleItemName());
        saleItem.setSaleItemPrice(saleItemDTO.saleItemPrice());
        return saleItem;
    }

}
