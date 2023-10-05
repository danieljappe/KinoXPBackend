package com.example.kinoxpbackend.repositoryAllSale;

import com.example.kinoxpbackend.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
