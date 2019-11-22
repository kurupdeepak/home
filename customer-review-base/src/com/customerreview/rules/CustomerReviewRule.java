package com.customerreview.rules;

import com.customerreview.model.CustomerReview;
import com.customerreview.service.InvalidReviewException;

public interface CustomerReviewRule {
    boolean apply(CustomerReview review) throws InvalidReviewException;
}
