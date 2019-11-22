package com.customerreview.module.review.dao;

import com.customerreview.module.product.model.Product;
import com.customerreview.module.review.model.CustomerReview;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerReviewDAO extends CrudRepository<CustomerReview, Integer> {
    //
//    List<CustomerReview> findAllByProductIdAndRatingBetween(Product product, int min, int max);
    @Query("select cr from CustomerReview cr where cr.productId = ?1 and cr.rating >= ?2 or cr.rating <= ?3")
    List<CustomerReview> findReviewsForProduct(Product product, int min, int max);

    @Query("select cr from CustomerReview cr where cr.customerId=?1")
    List<CustomerReview> findByCustomerId(int cid);
}
