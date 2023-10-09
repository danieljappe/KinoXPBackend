package com.example.kinoxpbackend.dtoSale;

import com.example.kinoxpbackend.model.Sale;
import com.example.kinoxpbackend.model.SaleDetail;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SaleConverter {

    public SaleDTO toDTO(Sale sale) {
       // Set<SaleDetailDTO> saleDetailDTOs = convertSaleDetailsToDTOs(sale.getSaleDetails());

        return new SaleDTO(sale.getSaleId(),
                sale.getSaleDate(),
                sale.getCustomerPhone());
    }

    public Sale toEntity(SaleDTO saleDTO) {
        Sale sale = new Sale();

        sale.setSaleId(saleDTO.saleID());
        sale.setSaleDate(saleDTO.saleDate());
        sale.setCustomerPhone(sale.getCustomerPhone());
        sale.setSaleDetails(sale.getSaleDetails());
        return sale;
    }

       /* private Set<SaleDetailDTO> convertSaleDetailsToDTOs(Set<SaleDetail> saleDetails) {
        Set<SaleDetailDTO> saleDetailDTOs = new HashSet<>();

        for (SaleDetail saleDetail : saleDetails) {
            SaleDetailDTO saleDetailDTO = new SaleDetailDTO(saleDetail.getSaleDetailId(), saleDetail(),
                    saleDetail.getSaleItem(), saleDetail.getQuantity());
            saleDetailDTOs.add(saleDetailDTO);
        }

        return saleDetailDTOs;
    }*/

}






