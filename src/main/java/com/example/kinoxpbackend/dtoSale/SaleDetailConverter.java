package com.example.kinoxpbackend.dtoSale;

import com.example.kinoxpbackend.model.SaleDetail;
import com.example.kinoxpbackend.model.SaleItem;
import com.example.kinoxpbackend.repositoryAllSale.SaleItemRepository;
import com.example.kinoxpbackend.repositoryAllSale.SaleRepository;
import org.springframework.stereotype.Component;

@Component
public class SaleDetailConverter {

    private final SaleRepository saleRepository;
    private final SaleItemRepository saleItemRepository;

    public SaleDetailConverter(SaleRepository saleRepository, SaleItemRepository saleItemRepository) {
        this.saleRepository = saleRepository;
        this.saleItemRepository = saleItemRepository;
    }

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
/*
        Sale sale = saleRepository.findById(saleDetailDTO.saleId())
                .orElseThrow(() -> new EntityNotFoundException("Sale not found for id: " + saleDetailDTO.saleId()));
        saleDetail.setSale(sale);

        SaleItem saleItem = saleItemRepository.findById(saleDetailDTO.saleItemId())
                .orElseThrow(() -> new EntityNotFoundException("SaleItem not found for id: " + saleDetailDTO.saleItemId()));
        saleDetail.setSaleItem(saleItem);


 */
        saleDetail.setQuantity(saleDetailDTO.quantity());
        return saleDetail;
    }
}
