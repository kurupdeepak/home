package com.customerreview;

import com.customerreview.module.review.rules.CustomerCommentsCheckForCurseWordsRule;
import com.customerreview.module.review.rules.CustomerRatingZeroCheckRule;
import com.customerreview.module.review.rules.CustomerReviewRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CustomerReviewConfig {

    @Bean
    public List<CustomerReviewRule> rulesToCheck(){
        return Arrays.asList(zeroRatingCheck(),curseWordCheck());
    }

    @Bean
    public CustomerReviewRule zeroRatingCheck(){
        return new CustomerRatingZeroCheckRule();
    }

    @Bean
    public CustomerReviewRule curseWordCheck(){
        return new CustomerCommentsCheckForCurseWordsRule();
    }
}
