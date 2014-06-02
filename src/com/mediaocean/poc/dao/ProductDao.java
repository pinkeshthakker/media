package com.mediaocean.poc.dao;

import java.util.List;

import com.mediaocean.poc.entity.Product;

public interface ProductDao extends AbstractDao<Product, String> {
    
    List<Product> getAllProducts();
    List getAllProductsSalesAndCount();
}
