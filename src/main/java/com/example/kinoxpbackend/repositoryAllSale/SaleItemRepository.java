package com.example.kinoxpbackend.repositoryAllSale;

import com.example.kinoxpbackend.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Integer> {
}
