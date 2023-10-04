package com.example.kinoxpbackend.dtoSale;

import com.example.kinoxpbackend.model.Sale;
import com.example.kinoxpbackend.model.SaleItem;

public record SaleDetailDTO(long saleDetailID, Sale sale,SaleItem saleItem, int quantity) {

}
