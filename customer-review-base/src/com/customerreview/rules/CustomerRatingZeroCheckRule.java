package com.customerreview.rules;

import com.customerreview.model.CustomerReview;

public class CustomerRatingZeroCheckRule implements CustomerReviewRule {
    @Override
    public boolean apply(CustomerReview customerReview) {
        return false;
    }
}
