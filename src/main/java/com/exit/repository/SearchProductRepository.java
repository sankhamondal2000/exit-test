package com.exit.repository;

import com.exit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    This repository is used to search the product by brand, name and product code
 */
@Repository
public interface SearchProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p from Product p Where INSTR(Concat(p.productCode,p.brand,p.name),:search)>0 or INSTR(Concat(p.productCode,p.name,p.brand),:search)>0 or INSTR(Concat(p.brand,p.productCode,p.name),:search)>0 or INSTR(Concat(p.brand,p.name,p.productCode),:search)>0 or INSTR(Concat(p.name,p.productCode,p.brand),:search)>0 or INSTR(Concat(p.name,p.brand,p.productCode),:search)>0 ")
    public List<Product> findBySearch(@Param("search") String search);
}
