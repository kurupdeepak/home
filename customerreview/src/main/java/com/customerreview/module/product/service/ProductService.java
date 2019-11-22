package com.customerreview.module.product.service;

import com.customerreview.module.product.model.Product;

import java.util.List;

public interface ProductService {
    int addProduct(String name);
    void deleteProduct(int id);
    void updateProduct(int id, String name);
    List<Product> getAllProducts();
}
