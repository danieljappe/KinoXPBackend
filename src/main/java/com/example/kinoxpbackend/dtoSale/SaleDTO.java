package com.example.kinoxpbackend.dtoSale;

import com.example.kinoxpbackend.model.SaleDetail;

import java.util.Date;
import java.util.Set;

public record SaleDTO(long saleID, Date saleDate, Integer customerPhone, Set<SaleDetailDTO> saleDetails) {
    @Override
    public long saleID() {
        return saleID;
    }

    @Override
    public Date saleDate() {
        return saleDate;
    }

    @Override
    public Integer customerPhone() {
        return customerPhone;
    }

    @Override
    public Set<SaleDetailDTO> saleDetails() {
        return saleDetails;
    }
}
