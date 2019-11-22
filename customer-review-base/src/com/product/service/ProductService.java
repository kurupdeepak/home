package com.product.service;

import com.product.model.Product;

import java.util.List;

public interface ProductService {
    int addProduct(String name);
    int deleteProduct(int id);
    int updateProduct(Product product);
    List<Product> getAllProducts();
}
