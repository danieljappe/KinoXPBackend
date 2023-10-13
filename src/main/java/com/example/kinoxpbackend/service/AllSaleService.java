package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.dto.dtoSale.*;
import com.example.kinoxpbackend.model.Sale;
import com.example.kinoxpbackend.model.SaleDetail;
import com.example.kinoxpbackend.model.SaleItem;
import com.example.kinoxpbackend.repositoryAllSale.SaleDetailRepository;
import com.example.kinoxpbackend.repositoryAllSale.SaleItemRepository;
import com.example.kinoxpbackend.repositoryAllSale.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AllSaleService {

    @Autowired
    SaleItemConverter saleItemConverter;
    @Autowired
    SaleItemRepository saleItemRepository;
    @Autowired
    SaleDetailConverter saleDetailConverter;
    @Autowired
    SaleDetailRepository saleDetailRepository;
    @Autowired
    SaleConverter saleConverter;
    @Autowired
    SaleRepository saleRepository;

    // Methods for Sale CRUD operations
    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale sale = saleConverter.toEntity(saleDTO);
        Sale savedSale = saleRepository.save(sale);
        return saleConverter.toDTO(savedSale);
    }

    public SaleDTO getSaleById(Long saleId) {
        Sale sale = saleRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found for id: " + saleId));
        return saleConverter.toDTO(sale);
    }

    public List<SaleDTO> getAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream().map(saleConverter::toDTO).collect(Collectors.toList());
    }

    public SaleDTO updateSale(Long saleId, SaleDTO updatedSaleDTO) {
        Sale existingSale = saleRepository.findById(saleId)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found for id: " + saleId));

        existingSale.setSaleDate(updatedSaleDTO.saleDate());
        existingSale.setCustomerPhone(updatedSaleDTO.customerPhone());

        Sale updatedSale = saleRepository.save(existingSale);
        return saleConverter.toDTO(updatedSale);
    }

    public void deleteSale(Long saleId) {
        saleRepository.deleteById(saleId);
    }


    // Methods for SaleItem CRUD operations
    public SaleItemDTO createSaleItem(SaleItemDTO saleItemDTO) {
        SaleItem saleItem = saleItemConverter.toEntity(saleItemDTO);
        SaleItem savedSaleItem = saleItemRepository.save(saleItem);
        return saleItemConverter.toDTO(savedSaleItem);
    }

    public SaleItemDTO getSaleItemById(Long saleItemId) {
        SaleItem saleItem = saleItemRepository.findById(saleItemId)
                .orElseThrow(() -> new EntityNotFoundException("SaleItem not found for id: " + saleItemId));
        return saleItemConverter.toDTO(saleItem);
    }

    public List<SaleItemDTO> getAllSaleItems() {
        List<SaleItem> saleItems = saleItemRepository.findAll();
        return saleItems.stream().map(saleItemConverter::toDTO).collect(Collectors.toList());
    }

    public SaleItemDTO updateSaleItem(Long saleItemId, SaleItemDTO updatedSaleItemDTO) {
        SaleItem existingSaleItem = saleItemRepository.findById(saleItemId)
                .orElseThrow(() -> new EntityNotFoundException("SaleItem not found for id: " + saleItemId));

        existingSaleItem.setSaleItemPrice(updatedSaleItemDTO.saleItemPrice());
        existingSaleItem.setSaleItemName(updatedSaleItemDTO.saleItemName());

        SaleItem updatedSaleItem = saleItemRepository.save(existingSaleItem);
        return saleItemConverter.toDTO(updatedSaleItem);
    }


    public void deleteSaleItem(Long saleItemId) {
        saleItemRepository.deleteById(saleItemId);
    }

    // Methods for SaleDetail CRUD operations

    public SaleDetailDTO createSaleDetail(SaleDetailDTO saleDetailDTO) {
        SaleDetail saleDetail = saleDetailConverter.toEntity(saleDetailDTO);
        SaleDetail savedSaleDetail = saleDetailRepository.save(saleDetail);
        return saleDetailConverter.toDTO(savedSaleDetail);
    }

    public SaleDetailDTO getSaleDetailById(Long saleDetailId) {
        SaleDetail saleDetail = saleDetailRepository.findById(saleDetailId)
                .orElseThrow(() -> new EntityNotFoundException("SaleDetail not found for id: " + saleDetailId));
        return saleDetailConverter.toDTO(saleDetail);
    }

    public List<SaleDetailDTO> getAllSaleDetails() {
        List<SaleDetail> saleDetails = saleDetailRepository.findAll();
        return saleDetails.stream().map(saleDetailConverter::toDTO).collect(Collectors.toList());
    }

   public SaleDetailDTO updateSaleDetail(Long saleDetailId, SaleDetailDTO updatedSaleDetailDTO) {
        SaleDetail existingSaleDetail = saleDetailRepository.findById(saleDetailId)
                .orElseThrow(() -> new EntityNotFoundException("SaleDetail not found for id: " + saleDetailId));

        existingSaleDetail.setSale(saleConverter.toEntity(updatedSaleDetailDTO.saleDTO()));
        existingSaleDetail.setSaleItem(saleItemConverter.toEntity(updatedSaleDetailDTO.saleItemDTO()));
        existingSaleDetail.setQuantity(updatedSaleDetailDTO.quantity());

        SaleDetail updatedSaleDetail = saleDetailRepository.save(existingSaleDetail);
        return saleDetailConverter.toDTO(updatedSaleDetail);
    }

    public void deleteSaleDetail(Long saleDetailId) {
        saleDetailRepository.deleteById(saleDetailId);
    }

}




