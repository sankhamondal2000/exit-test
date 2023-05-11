package com.exit.service;

import com.exit.model.Product;

import java.util.List;

/*
    Interface fpr find the min and max product range
 */
public interface PriceProductService {

    /*
        This method is used to fetch the maximum and minimum price of the product
    */
    public List<Product> searchPrice(int min, int max);
}
