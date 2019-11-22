package com.customerreview.module.review.service;

import com.customerreview.module.review.model.CustomerReview;

import java.util.List;

public interface CustomerReviewService {
    int addReview(CustomerReview review) throws InvalidReviewException;

    List<CustomerReview> getProductReviewInRange(int min, int max);

    List<CustomerReview> getProductReviewInRange(int product, int min, int max);

    List<CustomerReview> getReview(int cid);
}
