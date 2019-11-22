package com.customerreview.module.review.service;

import com.customerreview.module.curseword.service.NotFoundException;
import com.customerreview.module.product.dao.ProductDAO;
import com.customerreview.module.product.model.Product;
import com.customerreview.module.review.dao.CustomerReviewDAO;
import com.customerreview.module.review.model.CustomerReview;
import com.customerreview.module.review.rules.CustomerReviewRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerReviewServiceImpl implements CustomerReviewService {
    @Autowired
    List<CustomerReviewRule> rulesToCheck;

    @Autowired
    CustomerReviewDAO customerReviewDAO;

    @Autowired
    ProductDAO productDAO;

    @Override
    public int addReview(CustomerReview review) throws InvalidReviewException {
        if(!checkRules(review))
            throw new InvalidReviewException("Add Review failed, initialization error");
        review = customerReviewDAO.save(review);
        return review.getReviewId();
    }

    @Override
    public List<CustomerReview> getProductReviewInRange(int min, int max) {
        throw new NotImplementedException();
    }


    protected boolean checkRules(CustomerReview review){
        if((rulesToCheck != null) && (rulesToCheck.isEmpty())) {
            return false;
        }
        for(CustomerReviewRule rule: rulesToCheck){
                rule.apply(review);
        }
        return true;
    }

    @Override
    public List<CustomerReview> getProductReviewInRange(int product, int min, int max) {
        Optional<Product> p = productDAO.findById(product);
        if(!p.isPresent())
            throw new NotFoundException("Product not found " + product);

        return customerReviewDAO.findReviewsForProduct(p.get(),min,max);
    }

    @Override
    public List<CustomerReview> getReview(int cid) {
        return customerReviewDAO.findByCustomerId(cid);
    }

}
