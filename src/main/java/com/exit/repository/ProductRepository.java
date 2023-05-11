package com.exit.repository;

import com.exit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    This repository is used to perform all product related operation
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByNameLike(String name);
}
