package com.customerreview.module.review.rules;

import com.customerreview.module.review.model.CustomerReview;
import com.customerreview.module.review.service.InvalidReviewException;

public interface CustomerReviewRule {
    boolean apply(CustomerReview review) throws InvalidReviewException;
}
