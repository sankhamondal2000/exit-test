package com.exit.service.impl;

import com.exit.model.Product;
import com.exit.repository.PriceProductRepository;
import com.exit.service.PriceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Implementation class of PriceProductService interface
 */
@Service
public class PriceProductServiceImpl implements PriceProductService {

    @Autowired
    private PriceProductRepository searchProductRepository;

    /*
        This will find the product by minimum and maximum value
     */
    @Override
    public List<Product> searchPrice(int min, int max) {
        return searchProductRepository.searchPrice(min, max);
    }
}
