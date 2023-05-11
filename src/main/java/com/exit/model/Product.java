package com.exit.model;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/*
    This class will create the product table in database
 */
@Entity
public class Product {

    @Id
    private Long id;
    private String name;
    private int price;
    private String details;
    @Column(length = 5000)
    private String category;
    private String brand;
    private String productCode;
    private String image;

    public Product() {
    }

    public Product(Long id, String name, int price, String details, String category, String brand, String productCode, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.details = details;
        this.category = category;
        this.brand = brand;
        this.productCode = productCode;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
