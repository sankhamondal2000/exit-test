package com.exit.controller;

import com.exit.model.Product;
import com.exit.service.SearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    This controller is used to find the product by product code, name and brand
 */
@RestController
@RequestMapping("/getProductBySearch")
@CrossOrigin("*")
public class SearchProductController {

    @Autowired
    private SearchProductService searchProductService;

    /*
        This method is used to search the product according to the user input by url
     */
    @GetMapping("/{productSearch}")
    public List<Product> getProductListBySearch(@PathVariable("productSearch") String productSearch) throws Exception {
        productSearch = productSearch.replaceAll(" "," ");
        List<Product> productList;
        try {
            productList = searchProductService.getProductListBySearch(productSearch);
        } catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return productList;
    }
}
