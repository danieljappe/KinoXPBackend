package com.example.kinoxpbackend.service;


import com.example.kinoxpbackend.dtoSale.*;
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


    private final SaleItemRepository saleItemRepository;
    private final SaleDetailRepository saleDetailRepository;
    private final SaleRepository saleRepository;
    private final SaleItemConverter saleItemConverter;
    private final SaleDetailConverter saleDetailConverter;
    private final SaleConverter saleConverter;

    @Autowired
    public AllSaleService(
            SaleItemRepository saleItemRepository,
            SaleDetailRepository saleDetailRepository,
            SaleRepository saleRepository,
            SaleItemConverter saleItemConverter,
            SaleDetailConverter saleDetailConverter,
            SaleConverter saleConverter
    ) {
        this.saleItemRepository = saleItemRepository;
        this.saleDetailRepository = saleDetailRepository;
        this.saleRepository = saleRepository;
        this.saleItemConverter = saleItemConverter;
        this.saleDetailConverter = saleDetailConverter;
        this.saleConverter = saleConverter;
    }

    //todo Methods for SaleItem CRUD operations
    public SaleItemDTO createSaleItem(SaleItemDTO saleItemDTO) {
        SaleItem saleItem = saleItemConverter.toEntity(saleItemDTO);
        SaleItem savedSaleItem = saleItemRepository.save(saleItem);
        return saleItemConverter.toDTO(savedSaleItem);
    }

    public SaleItemDTO getSaleItemById(long saleItemId) {
        int saleItemIdAsInt = Math.toIntExact(saleItemId);
        SaleItem saleItem = saleItemRepository.findById(saleItemIdAsInt)
                .orElseThrow(() -> new EntityNotFoundException("SaleItem not found for id: " + saleItemId));
        return saleItemConverter.toDTO(saleItem);
    }

    public List<SaleItemDTO> getAllSaleItems(){
        List<SaleItem> saleItems = saleItemRepository.findAll();
        return saleItems.stream()
                .map(saleItemConverter::toDTO)
                .collect(Collectors.toList());
    }

    public SaleItemDTO updateSaleItem(long saleItemId, SaleItemDTO updatedSaleItemDTO){
        int saleItemIdAsInt = Math.toIntExact(saleItemId);
        SaleItem existingSaleItem = saleItemRepository.findById(saleItemIdAsInt)
                .orElseThrow(() -> new EntityNotFoundException("SaleItem not found for id: " + saleItemId));

        SaleItem updatedSaleItem = saleItemRepository.save(existingSaleItem);
        return saleItemConverter.toDTO(updatedSaleItem);
    }


    public void deleteSaleItem(Long saleItemId) {
        int saleItemIdAsInt = Math.toIntExact(saleItemId);
        saleItemRepository.deleteById(saleItemIdAsInt);
    }
    //todo Methods for SaleDetail CRUD operations

    public SaleDetailDTO createSaleDetail(SaleDetailDTO saleDetailDTO) {
        SaleDetail saleDetail = saleDetailConverter.toEntity(saleDetailDTO);
        SaleDetail savedSaleDetail = saleDetailRepository.save(saleDetail);
        return saleDetailConverter.toDTO(savedSaleDetail);
    }

    public SaleDetailDTO getSaleDetailById(Long saleDetailId) {
        int saleDetailIdAsInt = Math.toIntExact(saleDetailId);
        SaleDetail saleDetail = saleDetailRepository.findById(saleDetailIdAsInt)
                .orElseThrow(() -> new EntityNotFoundException("SaleDetail not found for id: " + saleDetailId));
        return saleDetailConverter.toDTO(saleDetail);
    }

    public List<SaleDetailDTO> getAllSaleDetails() {
        List<SaleDetail> saleDetails = saleDetailRepository.findAll();
        return saleDetails.stream()
                .map(saleDetailConverter::toDTO)
                .collect(Collectors.toList());
    }

    public SaleDetailDTO updateSaleDetail(Long saleDetailId, SaleDetailDTO updatedSaleDetailDTO) {
        int saleDetailIdAsInt = Math.toIntExact(saleDetailId);
        SaleDetail existingSaleDetail = saleDetailRepository.findById(saleDetailIdAsInt)
                .orElseThrow(() -> new EntityNotFoundException("SaleDetail not found for id: " + saleDetailId));

        // Update the existing SaleDetail entity with data from updatedSaleDetailDTO
        // Be sure to handle the update logic according to your requirements

        SaleDetail updatedSaleDetail = saleDetailRepository.save(existingSaleDetail);
        return saleDetailConverter.toDTO(updatedSaleDetail);
    }

    public void deleteSaleDetail(long saleDetailId) {
        int saleDetailIdAsInt = Math.toIntExact(saleDetailId);
        saleDetailRepository.deleteById(saleDetailIdAsInt);
    }

    //todo: Methods for Sale CRUD operations
    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale sale = saleConverter.toEntity(saleDTO);
        Sale savedSale = saleRepository.save(sale);
        return saleConverter.toDTO(savedSale);
    }

    public SaleDTO getSaleById(Long saleId) {
        int saleIdAsInt = Math.toIntExact(saleId);
        Sale sale = saleRepository.findById(saleIdAsInt)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found for id: " + saleId));
        return saleConverter.toDTO(sale);
    }

    public List<SaleDTO> getAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream()
                .map(saleConverter::toDTO)
                .collect(Collectors.toList());
    }

    public SaleDTO updateSale(Long saleId, SaleDTO updatedSaleDTO) {
        int saleIdAsInt = Math.toIntExact(saleId);
        Sale existingSale = saleRepository.findById(saleIdAsInt)
                .orElseThrow(() -> new EntityNotFoundException("Sale not found for id: " + saleId));

        // Update the existing Sale entity with data from updatedSaleDTO
        // Be sure to handle the update logic according to your requirements

        Sale updatedSale = saleRepository.save(existingSale);
        return saleConverter.toDTO(updatedSale);
    }

    public void deleteSale(Long saleId) {
        int saleIdAsInt = Math.toIntExact(saleId);
        saleRepository.deleteById(saleIdAsInt);
    }



}




