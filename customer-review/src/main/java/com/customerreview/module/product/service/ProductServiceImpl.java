package com.customerreview.module.product.service;

import com.customerreview.module.curseword.service.NotFoundException;
import com.customerreview.module.product.dao.ProductDAO;
import com.customerreview.module.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Override
    public int addProduct(String name) {
        Product p = productDAO.save(new Product(name));
        return p.getProductId();
    }

    @Override
    public void deleteProduct(int id) {
        Optional<Product> p = productDAO.findById(id);
        if(!p.isPresent())
            throw new NotFoundException("Delete failed : product not found " + id);
        productDAO.delete(p.get());
    }

    @Override
    public void updateProduct(int product, String name) {
        Optional<Product> p = productDAO.findById(product);
        if(!p.isPresent())
            throw new NotFoundException("Delete failed : product not found " + product);
        p.get().setProductName(name);
        productDAO.save(p.get());
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productDAO.findAll();
    }

    @Override
    public Product getProduct(int id) {
        Optional<Product> p = productDAO.findById(id);
        if(!p.isPresent()){
            throw new NotFoundException("Product not found : "+ id);
        }
        return p.get();
    }
}
