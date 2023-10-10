package com.example.kinoxpbackend.dto.dtoSale;

import com.example.kinoxpbackend.model.Sale;
import com.example.kinoxpbackend.model.SaleDetail;
import com.example.kinoxpbackend.model.SaleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleDetailConverter {

    @Autowired
    SaleConverter saleConverter;

    @Autowired
    SaleItemConverter saleItemConverter;
    public SaleDetailDTO toDTO(SaleDetail saleDetail) {
        SaleDTO saleDTO = saleConverter.toDTO(saleDetail.getSale());
        SaleItemDTO saleItemDTO = saleItemConverter.toDTO(saleDetail.getSaleItem());
        return new SaleDetailDTO(
                saleDetail.getSaleDetailId(),
                saleDTO,
                saleItemDTO,
                saleDetail.getQuantity()
        );
    }

    public SaleDetail toEntity(SaleDetailDTO saleDetailDTO) {
        SaleDetail saleDetail = new SaleDetail();
        Sale saleDTO = saleConverter.toEntity(saleDetailDTO.saleDTO());
        SaleItem saleItemDTO = saleItemConverter.toEntity(saleDetailDTO.saleItemDTO());

        saleDetail.setSaleDetailId(saleDetailDTO.saleDetailID());
        saleDetail.setSale(saleDTO);
        saleDetail.setSaleItem(saleItemDTO);
        saleDetail.setQuantity(saleDetailDTO.quantity());

        return saleDetail;


    }
}
