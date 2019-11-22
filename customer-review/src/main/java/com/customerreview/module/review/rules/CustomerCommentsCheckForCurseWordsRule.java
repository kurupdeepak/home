package com.customerreview.module.review.rules;

import com.customerreview.module.curseword.dao.CurseWordDAO;
import com.customerreview.module.curseword.model.CurseWord;
import com.customerreview.module.review.model.CustomerReview;
import com.customerreview.module.review.service.InvalidReviewException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
            if(customerReview.getComments().toLowerCase().contains(word.getWord().toLowerCase()))
                throw new InvalidReviewException("Comment cannot contain " + word.getWord());
        }
        return true;
    }
}
