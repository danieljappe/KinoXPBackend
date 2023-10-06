package com.example.kinoxpbackend.repositoryAllSale;

import com.example.kinoxpbackend.model.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
}
