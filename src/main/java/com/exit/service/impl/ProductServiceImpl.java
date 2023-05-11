package com.exit.service.impl;

import com.exit.model.Product;
import com.exit.repository.ProductRepository;
import com.exit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/*
    Implementation class of ProductService
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    /*
        To get all the product
     */
    @Override
    public Set<Product> getProducts() {
        return new HashSet<>(this.productRepository.findAll());
    }
    /*
        To get a single product by its ID
     */
    @Override
    public Optional<Product> getProduct(Long id) {
        return this.productRepository.findById(id);
    }


}
