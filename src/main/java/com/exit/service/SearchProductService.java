package com.exit.service;

import com.exit.model.Product;

import java.util.List;

/*
    Product search interface
 */
public interface SearchProductService {
    /*
        This method will search the product
     */
    public List<Product> getProductListBySearch(String search);
}
