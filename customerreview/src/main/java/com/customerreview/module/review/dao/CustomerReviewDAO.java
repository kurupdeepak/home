package com.customerreview.module.review.dao;

import com.customerreview.module.review.model.CustomerReview;
import com.customerreview.module.product.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerReviewDAO extends CrudRepository<CustomerReview,Integer> {
    List<CustomerReview> findAllByProductRatingBetween(int min, int max, int product);
}
