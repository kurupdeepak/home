package com.customerreview.dao;

import com.customerreview.model.CustomerReview;
import com.product.model.Product;

import java.util.List;

public interface CustomerReviewDAO {
    List<CustomerReview> findProductReviewsInRange(Product product,int min,int max);
}
