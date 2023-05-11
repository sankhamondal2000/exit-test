package com.exit.repository;

import com.exit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    This repository is used to fetch the maximum and minimum price of the product
 */
@Repository
public interface PriceProductRepository extends JpaRepository<Product, Long> {

    @Query("from Product where price between :min and :max")
    public List<Product> searchPrice(@Param("min") int min, @Param("max") int max);
}
