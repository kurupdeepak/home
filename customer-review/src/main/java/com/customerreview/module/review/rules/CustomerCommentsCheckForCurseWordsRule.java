package com.customerreview.module.review.rules;

import com.customerreview.module.common.dao.CurseWordDAO;
import com.customerreview.module.common.model.CurseWord;
import com.customerreview.module.review.model.CustomerReview;
import com.customerreview.module.review.service.InvalidReviewException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@Qualifier("curseWordCheckRule")
public class CustomerCommentsCheckForCurseWordsRule implements CustomerReviewRule{

    @Autowired
    CurseWordDAO curseWordDAO;

    @Override
    public boolean apply(CustomerReview customerReview) {
        Iterable<CurseWord> words = curseWordDAO.findAll();
        for(CurseWord word: words){
            if(customerReview.getComments().contains(word.getWord()))
                throw new InvalidReviewException("Comment cannot contain " + word.getWord());
        }
        return true;
    }
}
