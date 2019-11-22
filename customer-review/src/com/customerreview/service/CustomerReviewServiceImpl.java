package com.customerreview.service;

import com.customer.model.Customer;
import com.customerreview.model.CustomerReview;
import com.customerreview.rules.CustomerReviewRule;
import com.product.model.Product;
import com.customerreview.service.CustomerReviewService;
import com.customerreview.service.InvalidReviewException;

import java.util.List;

public class CustomerReviewServiceImpl implements CustomerReviewService {
    List<CustomerReviewRule> rulesToCheck;

    public CustomerReviewServiceImpl() {
    }

    public CustomerReviewServiceImpl(List<CustomerReviewRule> rulesToCheck) {
        this.rulesToCheck = rulesToCheck;
    }

    @Override
    public int addReview(CustomerReview review) throws InvalidReviewException {
        checkRules(review);
        return 1;
    }


    protected boolean checkRules(CustomerReview review){
        if((rulesToCheck != null) || (rulesToCheck.isEmpty()))
            return false;
        for(CustomerReviewRule rule: rulesToCheck){
                rule.apply(review);
        }
        return true;
    }

    @Override
    public List<CustomerReview> getProductReviewInRange(int min, int max) {
        return null;
    }
}
