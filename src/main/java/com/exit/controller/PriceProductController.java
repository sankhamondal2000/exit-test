package com.exit.controller;

import com.exit.model.Product;
import com.exit.service.PriceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
    Controller for sorting the product according to minimum and maximum price
 */
@RestController
@CrossOrigin("*")
public class PriceProductController {

    @Autowired
    private PriceProductService searchProductService;

    /*
        This method will fetch the minimum and maximum value put by the user and fetch this value from url
     */
    @GetMapping("/search/{min}/{max}/")
    public List<Product> searchPrice(@PathVariable("min")int min, @PathVariable("max")int max) throws Exception {
        List<Product> products;
        try {
            products = searchProductService.searchPrice(min, max);
        }
        catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
        return products;
    }
}
