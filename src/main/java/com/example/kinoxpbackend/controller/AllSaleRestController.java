package com.example.kinoxpbackend.controller;

import com.example.kinoxpbackend.dto.dtoSale.SaleDTO;
import com.example.kinoxpbackend.dto.dtoSale.SaleDetailDTO;
import com.example.kinoxpbackend.dto.dtoSale.SaleItemDTO;
import com.example.kinoxpbackend.model.SaleDetail;
import com.example.kinoxpbackend.service.AllSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/sales")
public class AllSaleRestController {

    @Autowired
    AllSaleService allSaleService;

    // rest controller til sale
    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO saleDTO) {
        SaleDTO createdSale = allSaleService.createSale(saleDTO);
        return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable Long saleId) {
        SaleDTO saleDTO = allSaleService.getSaleById(saleId);
        return new ResponseEntity<>(saleDTO, HttpStatus.OK);

    }

    @PutMapping("/{saleId}")
    public ResponseEntity<SaleDTO> updateSale(@PathVariable Long saleId, @RequestBody SaleDTO updatedSaleDTO) {

        SaleDTO updatedSale = allSaleService.updateSale(saleId, updatedSaleDTO);
        return new ResponseEntity<>(updatedSale, HttpStatus.OK);
    }

    @DeleteMapping("/{saleId}")
    public ResponseEntity<Void> deleteSale(@PathVariable Long saleId) {
        allSaleService.deleteSale(saleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //todo rest controller til  saleitem

    @PostMapping("/sale-items")
    public ResponseEntity<SaleItemDTO> createSaleItem(@RequestBody SaleItemDTO saleItemDTO) {
        SaleItemDTO createdSaleItem = allSaleService.createSaleItem(saleItemDTO);
        return new ResponseEntity<>(createdSaleItem, HttpStatus.CREATED);
    }

    @GetMapping("/sale-items/{saleItemId}")
    public ResponseEntity<SaleItemDTO> getSaleItemById(@PathVariable Long saleItemId) {
        SaleItemDTO saleItemDTO = allSaleService.getSaleItemById(saleItemId);
        return new ResponseEntity<>(saleItemDTO, HttpStatus.OK);
    }

    @GetMapping("/sale-items")
    public ResponseEntity<List<SaleItemDTO>> getAllSaleItems() {
        List<SaleItemDTO> saleItems = allSaleService.getAllSaleItems();
        return new ResponseEntity<>(saleItems, HttpStatus.OK);
    }

    @PutMapping("/sale-items/{saleItemId}")
    public ResponseEntity<SaleItemDTO> updateSaleItem(@PathVariable Long saleItemId, @RequestBody SaleItemDTO updatedSaleItemDTO) {
        SaleItemDTO updatedSaleItem = allSaleService.updateSaleItem(saleItemId, updatedSaleItemDTO);
        return new ResponseEntity<>(updatedSaleItem, HttpStatus.OK);
    }




    //TODO restcontroller til saleDetails

    @PostMapping("/sale-detail")
    public ResponseEntity<SaleDetailDTO> createSaleDetail(@RequestBody SaleDetailDTO saleDetailDTO) {
        SaleDetailDTO createdSaleDetail = allSaleService.createSaleDetail(saleDetailDTO);
        return new ResponseEntity<>(createdSaleDetail, HttpStatus.CREATED);
    }

    @GetMapping("sale-detail/{saleDetailId}")
    public ResponseEntity<SaleDetailDTO> getSaleDetailById(@PathVariable Long saleDetailId) {
        SaleDetailDTO saleDetailDTO = allSaleService.getSaleDetailById(saleDetailId);
        return new ResponseEntity<>(saleDetailDTO, HttpStatus.OK);
    }


    @PutMapping("sale-detail/{saleDetailId}")
    public ResponseEntity<SaleDetailDTO> updateSaleDetail(
            @PathVariable Long saleDetailId,
            @RequestBody SaleDetailDTO updatedSaleDetailDTO
    ) {
        SaleDetailDTO updatedSaleDetail = allSaleService.updateSaleDetail(saleDetailId, updatedSaleDetailDTO);
        return new ResponseEntity<>(updatedSaleDetail, HttpStatus.OK);
    }

    @DeleteMapping("sale-detail/{saleDetailId}")
    public ResponseEntity<Void> deleteSaleDetail(@PathVariable Long saleDetailId) {
        allSaleService.deleteSaleDetail(saleDetailId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
