package com.maiyeuem.productclothes.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")

public class Product {
    @Id
    private String productId;
    private int userId;
    private String name;
    private String slug;
    private String description;
    private String detail;
    private double price;
    private String image;
    private String manufacturer;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private int status;
}
