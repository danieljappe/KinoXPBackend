package com.example.kinoxpbackend.dtoSale;

import com.example.kinoxpbackend.model.Sale;
import com.example.kinoxpbackend.model.SaleItem;

public record SaleDetailDTO(long saleDetailID, Sale sale,SaleItem saleItem, int quantity) {
    @Override
    public long saleDetailID() {
        return saleDetailID;
    }

    @Override
    public Sale sale() {
        return sale;
    }

    @Override
    public SaleItem saleItem() {
        return saleItem;
    }

    @Override
    public int quantity() {
        return quantity;
    }
}
