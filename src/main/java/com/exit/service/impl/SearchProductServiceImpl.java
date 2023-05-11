package com.exit.service.impl;

import com.exit.model.Product;
import com.exit.repository.SearchProductRepository;
import com.exit.service.SearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
    Implementation class of SearchProductService
 */
@Service
public class SearchProductServiceImpl implements SearchProductService {

    @Autowired
    private SearchProductRepository searchProductRepository;

    /*
        This method is used to search the product
     */
    @Override
    public List<Product> getProductListBySearch(String search) {
        return searchProductRepository.findBySearch(search);
    }
}
