package com.example.kinoxpbackend.dtoSale;

import com.example.kinoxpbackend.model.SaleDetail;

import java.util.Date;
import java.util.Set;

public record SaleDTO(Long saleID, Date saleDate, Integer customerPhone) {


}

