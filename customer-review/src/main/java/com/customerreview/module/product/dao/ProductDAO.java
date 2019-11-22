package com.customerreview.module.product.dao;

import com.customerreview.module.product.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends CrudRepository<Product,Integer> {
}
