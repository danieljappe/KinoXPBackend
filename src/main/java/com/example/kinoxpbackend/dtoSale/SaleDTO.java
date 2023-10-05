package com.example.kinoxpbackend.dtoSale;

import java.util.Date;
import java.util.Set;

public record SaleDTO(long saleID, Date saleDate, Integer customerPhone, Set<SaleDetailDTO> saleDetails) {
}
