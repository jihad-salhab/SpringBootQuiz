package com.example.springbootquiz.models;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Products")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "product_name")
    String productName;
    @Column(name = "product_description")
    String productDescription;
    @Column(name = "product_category")
    String productCategory;
    @Column(name = "product_creation_date")
    Date productCreationDate;


}
