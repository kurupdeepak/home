package com.customerreview.rules;

import com.customerreview.model.CustomerReview;

public class CustomerCommentCheckForCurseWordsRule implements CustomerReviewRule{
    @Override
    public boolean apply(CustomerReview customerReview) {
        return false;
    }
}
