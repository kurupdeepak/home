package com.customerreview.module.product.controller;

import com.customerreview.module.product.model.Product;
import com.customerreview.module.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public int add(@RequestBody String product){
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody String product,@PathVariable int id){
        productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }
}
