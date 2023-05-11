package com.exit.service;

import com.exit.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/*
    Product service interface
 */
public interface ProductService {

    /*
        To get all the products
     */
    public Set<Product> getProducts();

    /*
        To get Single product
     */
    public Optional<Product> getProduct(Long id);

}
