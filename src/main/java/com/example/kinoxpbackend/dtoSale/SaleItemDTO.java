package com.example.kinoxpbackend.dtoSale;

public record SaleItemDTO(Long saleItemId, String saleItemName, Integer saleItemPrice) {
    @Override
    public Long saleItemId() {
        return saleItemId;
    }

    @Override
    public String saleItemName() {
        return saleItemName;
    }

    @Override
    public Integer saleItemPrice() {
        return saleItemPrice;
    }
}
