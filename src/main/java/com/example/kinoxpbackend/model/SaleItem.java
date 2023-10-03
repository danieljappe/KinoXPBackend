package com.example.kinoxpbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sale_item")
public class SaleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sale_item_id")
    private Long saleItemId;

    @Column(name = "sale_item_name")
    private String saleItemName;

    @Column(name = "sale_item_price")
    private Integer saleItemPrice;

    @OneToMany(mappedBy = "saleItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<SaleDetail> saleDetails;
}