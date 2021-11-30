package com.example.springbootquiz.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sales")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "sale_creation_date")
    Date saleCreationDate;
    @Column(name = "sale_client_name")
    String saleClientName;
    @Column(name = "sale_seller_name")
    String saleSellerName;
    @Column(name = "sale_product_name")
    String saleProductName;
    @Column(name = "sale_quantities")
    Integer saleQuantities;
    @Column(name = "sale_total")
    Float saleTotal;

}
