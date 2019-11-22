package com.customerreview.module.review.rules;

import com.customerreview.module.review.model.CustomerReview;
import com.customerreview.module.review.service.InvalidReviewException;

public class CustomerRatingZeroCheckRule implements CustomerReviewRule {
    @Override
    public boolean apply(CustomerReview customerReview) {
        if(customerReview.getRating() <= 0){
            throw new InvalidReviewException("Rating cannot be 0 or negative"  + customerReview.getRating());
        }
        return true;
    }
}
