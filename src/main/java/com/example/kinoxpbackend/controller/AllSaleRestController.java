package com.example.kinoxpbackend.controller;


import com.example.kinoxpbackend.dtoSale.SaleDTO;
import com.example.kinoxpbackend.service.AllSaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/sales")
public class AllSaleRestController {
    private final AllSaleService allSaleService;

    public AllSaleRestController(AllSaleService allSaleService) {
        this.allSaleService = allSaleService;
    }

    //todo rest controller til sale

    @PostMapping
    public ResponseEntity<SaleDTO> createSale(@RequestBody SaleDTO saleDTO) {
        SaleDTO createdSale = allSaleService.createSale(saleDTO);
        return new ResponseEntity<>(createdSale, HttpStatus.CREATED);
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SaleDTO> getSaleById(@PathVariable long saleId) {
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


}
