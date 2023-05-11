package com.exit.controller;


import com.exit.model.Product;
import com.exit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/*
    This controller is for add, delete, get all and get single product
 */
@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
        This method is for get single product by fetching its ID from url
     */
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id")Long id)
    {
        return this.productService.getProduct(id);
    }

    /*
        This method is for get all products
     */
    @GetMapping("/")
    public Set<Product> getProducts()
    {
        return this.productService.getProducts();
    }
}
