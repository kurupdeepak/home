package com.customerreview.module.review.dao;

import com.customerreview.module.review.model.CustomerReview;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerReviewDAO extends CrudRepository<CustomerReview,Integer> {
    List<CustomerReview> findAllByProductIdAndRatingBetween(int min, int max, int product);
}
