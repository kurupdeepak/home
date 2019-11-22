package com.customerreview.service;

import com.customer.model.Customer;
import com.customerreview.model.CustomerReview;
import com.product.model.Product;

import java.util.List;

public interface CustomerReviewService {
    int addReview(CustomerReview customerReview) throws InvalidReviewException;
    List<CustomerReview> getProductReviewInRange(int min, int max);
}
