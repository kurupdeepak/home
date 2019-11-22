package com.customerreview.module.review.service;

import com.customerreview.module.review.dao.CustomerReviewDAO;
import com.customerreview.module.review.model.CustomerReview;
import com.customerreview.module.review.rules.CustomerCommentCheckForCurseWordsRule;
import com.customerreview.module.review.rules.CustomerRatingZeroCheckRule;
import com.customerreview.module.review.rules.CustomerReviewRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerReviewServiceImpl implements CustomerReviewService {
    List<CustomerReviewRule> rulesToCheck;

    @Autowired
    CustomerReviewDAO customerReviewDAO;

    public CustomerReviewServiceImpl() {
        this.rulesToCheck = new ArrayList<>();
        rulesToCheck.add(new CustomerRatingZeroCheckRule());
        rulesToCheck.add(new CustomerCommentCheckForCurseWordsRule());
    }

    public CustomerReviewServiceImpl(List<CustomerReviewRule> rulesToCheck) {
        this.rulesToCheck = rulesToCheck;
    }

    @Override
    public int addReview(CustomerReview review) throws InvalidReviewException {
        checkRules(review);
        review = customerReviewDAO.save(review);
        return review.getReviewId();
    }

    @Override
    public List<CustomerReview> getProductReviewInRange(int min, int max) {
        throw new NotImplementedException();
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
    public List<CustomerReview> getProductReviewInRange(int product, int min, int max) {
        return customerReviewDAO.findAllByProductRatingBetween(product,min,max);
    }
}
